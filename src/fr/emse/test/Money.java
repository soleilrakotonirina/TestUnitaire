package fr.emse.test;

public class Money implements IMoney {

	public Money () {}
	
	private int fAmount;
	private String fCurrency;
	
	public Money(int amount, String currency) {
		fAmount = amount;
		fCurrency = currency;
	}
	
	public int amount() {
		return fAmount;
	}
	public String currency() {
		return fCurrency;
	}
	
    public String getCurrency() {
        return fCurrency;
    }
    public int getAmount() {
        return fAmount;
    }

//  public Money add(Money m) {
//		return new Money(amount() + m.amount(), currency());
//	}
	
//	public Money add(Money m) {
//		if (m.currency().equals(currency()))
//			return new Money(amount() + m.amount(), currency());
//		return new MoneyBag(this, m);
//	}

    public IMoney add(Money m){
        if (m.currency().equals(currency()))
        	return new Money(amount() + m.amount(), currency());
        else {
        	return new MoneyBag(this, m);
        }
    }
    
    @Override
    public IMoney add(IMoney money) {
        if (money instanceof Money) {
            Money other = (Money) money;
            if (this.getCurrency().equals(other.fCurrency)) {
                return new Money(this.getAmount() + other.getAmount(), this.getCurrency());
            } else {
                return new MoneyBag(this, other);
            }
        } else {
            return money.add(this); // Permet à IMoney de décider du type retourné
        }
        
    }
    
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Money other = (Money) obj;
        return fAmount == other.fAmount && fCurrency.equals(other.fCurrency);
	}

    
}


