package fr.emse.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class MoneyBag implements IMoney {
	
    private Vector<Money> fMonies = new Vector<Money>();

    public MoneyBag() {}

    public MoneyBag(Money m1, Money m2) {
        appendMoney(m1);
        appendMoney(m2);
    }

    public MoneyBag(Money bag[]) {
        for (int i = 0; i < bag.length; i++)
            appendMoney(bag[i]);
    }

    private void appendMoney(Money m) {
        if (fMonies.isEmpty()) {
            fMonies.add(m);
        } else {
            int i = 0;
            while ((i < fMonies.size())
                    && (!(fMonies.get(i).currency().equals(m.currency()))))
                i++;
            if (i >= fMonies.size()) {
                fMonies.add(m);
            } else {
                fMonies.set(i, new Money(fMonies.get(i).amount() +
                   m.amount(),
                   m.currency()));
            }
        }
    }

    public Vector<Money> getfMonies() {
        return fMonies;
    }

    public void setfMonies(Vector<Money> fMonies) {
        this.fMonies = fMonies;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        MoneyBag other = (MoneyBag) obj;
        return fMonies.equals(other.fMonies);
    }
  
    public String currency() {
        if (fMonies.isEmpty()) {
            throw new IllegalStateException("Cannot determine currency of an empty MoneyBag");
        } else {
            // Initialisation du compteur pour chaque devise
            Map<String, Integer> currencyCount = new HashMap<>();
            for (Money money : fMonies) {
                String currency = money.currency();
                currencyCount.put(currency, currencyCount.getOrDefault(currency, 0) + 1);
            }

            // Recherche de la devise la plus courante
            String mostCommonCurrency = null;
            int maxCount = 0;
            
            for (Map.Entry<String, Integer> entry : currencyCount.entrySet()) {
                if (entry.getValue() > maxCount) {
                    mostCommonCurrency = entry.getKey();
                    maxCount = entry.getValue();
                } else if (entry.getValue() == maxCount) {
                    mostCommonCurrency = entry.getKey();
                }
            }
            // Devise la plus courante
            return mostCommonCurrency;
        }
    }
    
    public IMoney add(MoneyBag bag) {
        // Vérifie si les devises des deux MoneyBag sont les mêmes
        if (this.currency().equals(bag.currency())) {
            // Si les devises sont identiques, combinaison simple des deux MoneyBag
            Vector<Money> combinedMonies = new Vector<>(this.getfMonies());
            combinedMonies.addAll(bag.getfMonies());
            return new MoneyBag(combinedMonies.toArray(new Money[0]));
        } else {
            // Si les devises sont différentes, création d'un nouveau MoneyBag contenant les deux
            Vector<Money> combinedMonies = new Vector<>();
            combinedMonies.addAll(this.getfMonies());
            combinedMonies.addAll(bag.getfMonies());
            return new MoneyBag(combinedMonies.toArray(new Money[0]));
        }
    }
	
//	@Override
//	public IMoney add(IMoney money) {
//	    if (money instanceof Money) {
//	        appendMoney((Money) money);
//	    } else if (money instanceof MoneyBag) {
//	        MoneyBag other = (MoneyBag) money;
//	        if (this.currency().equals(other.currency())) {
//	        	// Si les devises sont identiques, effectuez une simple addition des montants
//	            Money totalMoney = new Money(0, this.currency());
//	            for (Money m : other.getfMonies()) {
//	                totalMoney = (Money) totalMoney.add(m);
//	            }
//	            for (Money m : this.getfMonies()) {
//	                totalMoney = (Money) totalMoney.add(m);
//	            }
//	            return totalMoney; 
//	        } else {
//	        	// Si les devises sont différentes, créez un nouveau MoneyBag contenant les deux
//	            Vector<Money> combinedMonies = new Vector<>(this.getfMonies());
//	            for (Money m : other.getfMonies()) {
//	                combinedMonies.add(m);
//	            }
//	            return new MoneyBag(combinedMonies.toArray(new Money[0])); 
//	        }
//	    }
//	    return this;
//	}
    
    public IMoney add(IMoney money) {
        if (money instanceof Money) {
            appendMoney((Money) money);
        } else if (money instanceof MoneyBag) {
            MoneyBag other = (MoneyBag) money;
            if (this.currency().equals(other.currency())) {
                // Si les devises sont identiques, combiner les montants des deux MoneyBag
                Vector<Money> combinedMonies = new Vector<>(this.getfMonies());
                combinedMonies.addAll(other.getfMonies());
                return simplifyMoneyBag(new MoneyBag(combinedMonies.toArray(new Money[0])));
            } else {
                // Si les devises sont différentes, créer un nouveau MoneyBag contenant les deux
                Vector<Money> combinedMonies = new Vector<>(this.getfMonies());
                combinedMonies.addAll(other.getfMonies());
                return new MoneyBag(combinedMonies.toArray(new Money[0]));
            }
        }
        return this;
    }

    private IMoney simplifyMoneyBag(MoneyBag moneyBag) {
        // Si le MoneyBag contient une seule devise, simplifiez-le en un seul Money
        if (moneyBag.getfMonies().size() == 1) {
            return moneyBag.getfMonies().get(0);
        }
        return moneyBag;
    }


	
	// Méthode pour calculer la somme totale des montants dans ce MoneyBag et retourner un Money avec la devise commune
	public Money calculateTotalMoney() {
	    int totalAmount = 0;
	    for (Money money : fMonies) {
	        totalAmount += money.amount();
	    }
	    return new Money(totalAmount, currency());
	}

}


