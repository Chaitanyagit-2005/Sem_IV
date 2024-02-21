class SY2022bit041{
  
      static public void main(String args[]){
       
             int[] A10L = new int[1000000];
             int[] A20L = new int[2000000];
             int[] A30L = new int[3000000];
             SY2022bit041 cm = new SY2022bit041(); 
             int apr2 = cm.generateRandomNumberApr2();
         //    System.out.println(apr2);
             long startTime1 = System.currentTimeMillis();
             int prime1 = cm.getCountofPrime(A10L);
             long endTime1 = System.currentTimeMillis();
             System.out.println(prime1);
             long timeTaken1 = endTime1 - startTime1;
             System.out.println(timeTaken1);
             
             long startTime2 = System.currentTimeMillis();
             int prime2 = cm.getCountofPrime(A20L);
             long endTime2 = System.currentTimeMillis();
             System.out.println(prime2);
             long timeTaken2 = endTime2 - startTime2;
             System.out.println(timeTaken2);
             
             long startTime3 = System.currentTimeMillis();
             int prime3 = cm.getCountofPrime(A30L);
             long endTime3 = System.currentTimeMillis();
             System.out.println(prime3);
             long timeTaken3 = endTime3 - startTime3;
             System.out.println(timeTaken3);
             
             System.out.println();
             
         
      }
      
      public int generateRandomNumberApr1(){
          int randomNumber = (int) (System.nanoTime() % 10_00_00_00);
//System.out.println(randomNumber);
          return randomNumber;
      }
      
      public int generateRandomNumberApr2(){
          int randomNumber = (int) (System.currentTimeMillis() % 10_00_00_00);
         System.out.println(randomNumber);
          return randomNumber;
      }
      public boolean isPrime(int n) {  
       if (n <= 1) {  
           return false;  
       }  
       for (int i = 2; i <= Math.sqrt(n); i++) {  
           if (n % i == 0) {  
               return false;  
           }  
       }  
       return true;  
   }  
   public int getCountofPrime(int[] A10L){
         int primeCount = 0;
        for (int i = 0; i < A10L.length; i++) {
             A10L[i] = generateRandomNumberApr1();
             if(isPrime(A10L[i])){
                  primeCount++;
             }
         }
         return primeCount;
         
   }
   
      
}
