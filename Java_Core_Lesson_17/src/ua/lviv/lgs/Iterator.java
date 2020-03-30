package ua.lviv.lgs;

public interface Iterator {
	
	public boolean hasNext();
	public void next();
}

class Collection{
	
	private static Object [] numberArray;

	public Collection(Object [] numberArray) {
		Collection.numberArray = numberArray;
	}
	
	private class Forward implements Iterator{
		
		private int count = 0;

		@Override
		public boolean hasNext() {			
			return count < numberArray.length;
		}

		@Override
		public void next() {
			if(((Integer) ( numberArray[count]) + 1) % 2 == 0) {
				numberArray[count] = 0;
			}
			System.out.print(numberArray[count++] + ", "); 
		}		
	}
	
	public Forward createForward() {
		return new Forward();
	}
	
	private class Backward implements Iterator{
		
		private int count = numberArray.length - 1;

		@Override
		public boolean hasNext() {
			return count >= 0;
		}

		@Override
		public void next() {
			if(count % 2 == 0) {
				System.out.print(numberArray[count] + ", ");
			}
			count--;
		}		
	}
	
	public Backward createBackward() {
		return new Backward();
	}
	
	Iterator iteratorAnonymous() {
		return new Iterator() {

			private int count = numberArray.length - 1;

			@Override
			public boolean hasNext() {
				return count >= 0;
			}

			@Override
			public void next() {
				if (count % 3 == 0 && (((Integer) ( numberArray[count])) + 1) % 2 == 0) {
					System.out.print(numberArray[count] + ", ");
				}
				count--;
			}
		};
	}
	
	private Iterator iteratorLocal() {
		class LocalIterator implements Iterator{
			
			private int count = 0;

			@Override
			public boolean hasNext() {
				return count < numberArray.length;
			}

			@Override
			public void next() {
				if(count % 5 == 0 && ((Integer) ( numberArray[count])) % 2 == 0) {
					int result = ((Integer) ( numberArray[count])) - 100;
					System.out.print(result + ", ");
				}
				count++;
			}			
		}
		return new LocalIterator();		
	}	
	
	private static class IteratorStatic implements Iterator{
		
		private int count = 0;

		@Override
		public boolean hasNext() {
			return count < numberArray.length;
		}

		@Override
		public void next() {
			if(count % 2 == 0 && ((Integer) ( numberArray[count])) % 2 == 0) {
				int result = ((Integer) ( numberArray[count])) + 1;
				System.out.print(result + ", ");
			}
			count++;
		}
		
	}
	
	public IteratorStatic createStatic() {
		return new IteratorStatic();		
	}	
	
	public static class Method{
		
		public static void method1() {
				System.out.println("Method 1");
			Collection collection = new Collection(numberArray);
			
			for (Object integer : numberArray) {
				System.out.print(integer + ", ");
			}
			System.out.println();
			
			Iterator iteratorForward = collection.createForward();
			while(iteratorForward.hasNext()) {			
				iteratorForward.next();
			}
			System.out.println();
		}
		
		public static void method2() {
				System.out.println("Method 2");
			Collection collection = new Collection(numberArray);			
			Iterator iteratorBackrward = collection.createBackward();
			while(iteratorBackrward.hasNext()) {			
				iteratorBackrward.next();
			}
			System.out.println();
		}
		
		public static void method3() {
				System.out.println("Method 3");
			Collection collection = new Collection(numberArray);			
			Iterator iteratorAno = collection.iteratorAnonymous();
			while(iteratorAno.hasNext()) {			
				iteratorAno.next();
			}
			System.out.println();
		}		
		
		public static void method4() {
			System.out.println("Method 4");
			Collection collection = new Collection(numberArray);
			Iterator iteratorLoc = collection.iteratorLocal();
			while (iteratorLoc.hasNext()) {
				iteratorLoc.next();
			}
			System.out.println();
		}
		
		public static void method5() {
			System.out.println("Method 5");
			Collection collection = new Collection(numberArray);
			Iterator iteratorSta = collection.createStatic();
			while (iteratorSta.hasNext()) {
				iteratorSta.next();
			}
			System.out.println();
		}	
		
	}	
}
