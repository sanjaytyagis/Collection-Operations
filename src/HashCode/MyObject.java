package HashCode;

import CollectionOperationOnObject.Example;

/*
 * Explanation:
hashCode Method:

We compute the hash code using both field1 and field2.
We use the prime number 31 for combining hash codes, as it helps in distributing the hash values more evenly.
If field2 is null, we use 0 as its hash code to prevent NullPointerException.
equals Method:

We first perform reference checks and class checks to ensure that the compared object is of the correct type.
We then compare each field individually:
For field1, we simply compare the primitive values.
For field2, we handle the case where it might be null.
We return true if both objects have the same values for field1 and field2, and false otherwise.
By overriding these methods, you ensure that objects of your class behave correctly when used in collections like HashMap, HashSet, etc., 
where hashCode and equals methods are used to determine equality and to find objects efficiently based on their hash codes.
 */
public class MyObject {
    private int field1;
    private String field2;

    public MyObject() {
		super();
	}
    
    public MyObject(int field1, String field2) {
		super();
		this.field1 = field1;
		this.field2 = field2;
	}

    @Override
    public int hashCode() {
    	// hashCode can only be call on object like Integer not on int primitive
        final int prime = 31;
        int result = 1;
        result = prime * result + field1;
        result = prime * result + ((field2 == null) ? 0 : field2.hashCode());
        return result;
    }

	@Override
    public boolean equals(Object obj) {
		
        if (this instanceof Object) // this == obj
            return true;
        // getClass() - current class Name and obj.getClass() class object pass in equals method
        if (obj == null || getClass() != obj.getClass())
            return false;
        
        MyObject other = (MyObject) obj;
        
        if (field1 != other.field1)
            return false;
        
        if (field2 == null && other.field2 != null)          
                return false;

        else if (!field2.equals(other.field2))
            return false;
        
        return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyObject a = new MyObject(2,"San");
		MyObject b = new MyObject(2,"San");
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
		System.out.println(a.equals(b));	
	}
}
