package ch03;

class Ex3_2
{
	
	public static void main(String[] args) 
	{
		
		int numOfApples = 123;
		int sizeOfBucket = 10;
		int numOfBucket = (numOfApples / sizeOfBucket + (numOfApples%sizeOfBucket > 0 ? 1 : 0));
		
		//int numOfBucket = ((numOfApples % sizeOfBucket) == 0 ? (numOfApples / sizeOfBucket) : (numOfApples / sizeOfBucket + 1));//int-+
		
		/*
		 * int numOfBucket = 0;
		 * 
		 * if (numOfApples % sizeOfBucket == 0) {
		 * 
		 * numOfBucket = numOfApples / sizeOfBucket;
		 * 
		 * } else
		 * 
		 * {
		 * 
		 * numOfBucket = numOfApples / sizeOfBucket + 1;
		 * 
		 * }
		 */	
		System.out.println(numOfBucket);
		
	}

}