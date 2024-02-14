class SY2022bit041 {

    public static void main(String[] args) {
        // Test your logic here
        String[] registrations = {"2022bit041"};
        String[] A10K = new String[10000];
        String[] A20K = new String[20000];
        String[] A30K = new String[30000];

        SY2022bit041 cm = new SY2022bit041();
        
        
     //   String random = cm.generateRandomRegistrationNo();
     //   System.out.println(random);
        String[] a10K = new String[10000];     
        a10K = cm.displayRegNo(A10K);
        int validCount1 = cm.getValidRegistrationsCount(a10K);
        System.out.println(validCount1);
         String[] a20K = new String[20000];     
        a20K = cm.displayRegNo(A20K);
        int validCount2 = cm.getValidRegistrationsCount(a20K);
        System.out.println(validCount2);
         String[] a30K = new String[30000];     
        a30K = cm.displayRegNo(A30K);
        int validCount3 = cm.getValidRegistrationsCount(a30K);
        System.out.println(validCount3);
    }

    public int getValidRegistrationsCount(String[] registrations) {
       // Invalid input
        if (registrations == null) {
            return -1; 
        }

        int validCountRegNo = 0;
        for (String regNo : registrations) {
            if (isValidRegistration(regNo)) {
                validCountRegNo++;
            }
        }
        return validCountRegNo;
    }

    public boolean isValidRegistration(String inputRegNo) {
        if (inputRegNo.length() != 10) {
            return false;
        }

        int admissionYear = Integer.parseInt(inputRegNo.substring(0, 4));     //Stores year
        String inputBranchCode = inputRegNo.substring(4, 7);                  //Stores branch code
     //   char degreeChar = inputRegNo.charAt(5);

     //   System.out.println(inputBranchCode);
        if ((isValidYear(admissionYear)) &&
                (isValidBranch(inputBranchCode)) && (isValidSerialNo(inputRegNo))) {
           
            return true;
        }

        return false;
    }
    
 //Checks if the year is between 2000 and 2024
    public boolean isValidYear(int year) {
        return year >= 2000 && year <= 2024;
    }
    
    /*Checks if the brnchCode is valid or not
     Valid departments: bit, bcs, bme, bch */
    public boolean isValidBranch(String branchCode) {
        return branchCode.equalsIgnoreCase("bit") || branchCode.equalsIgnoreCase("bcs")
                || branchCode.equalsIgnoreCase("bme") || branchCode.equalsIgnoreCase("bch");
    }
    
    //Checks whether the 3 digit serial number contains all integer digits
    public boolean isValidSerialNo(String inputRegNo){
            for (int i = 7; i < inputRegNo.length(); i++) {
                if (!Character.isDigit(inputRegNo.charAt(i))) {
                    return false;
                }
            }
            return true;
    }
    public String[] displayRegNo(String[] A10K){
          int countReg = 0;

        for (int i = 0; i < A10K.length; i++) {
             A10K[i] = generateRandomRegistrationNo();
             System.out.println(A10K[i]);
              countReg++;
         }

         System.out.println("Generated " + countReg + " registration numbers.");
         return A10K;
    }
    
    public String generateRandomRegistrationNo(){
          int[] randomYear = new int[4];
          
          int[] randomBranchInt = new int[3];
          char[] randomBranchChar = new char[3];
          int[] randomSequence = new int[3];
          char[] randomSequenceChar = new char[4];
          String randomRegistration = "";
          int i = 0;
        for (i = 0; i < 4; i++) {
    // Generate Random year
    randomYear[i] = (int) (System.nanoTime() % 10);
    }

      // Ensure the generated year is 4 digits
              for (i = 0; i < 4; i++) {
                  randomYear[i] = randomYear[i] % 10;  // Ensure each digit is between 0 and 9
              }
        

             char[] randomYearChar = new char[randomYear.length];

                  for (i = 0; i < 4; i++) {
                          randomYearChar[i] = Character.forDigit(randomYear[i], 10);
                     }
          
         String randomYearString = String.valueOf(randomYearChar);
       
         // Create branch code 
         i=0;
          while(i <3){
              
             randomBranchInt[i] = (int)(System.nanoTime() % 25) + 97;
           
             if(randomBranchInt[i]>= 97 && randomBranchInt[i] <= 122){
                  randomBranchChar[i] = (char)randomBranchInt[i];
             
                  i++;
             }
          }
     
          String randomBranchString = String.valueOf(randomBranchChar);
    
          //Generate Random sequence
          for( i=0; i<3; i++){
          
             randomSequence[i] = (int)(System.nanoTime() % 10);
            
                                
          }
          for (i = 0; i < randomSequence.length; i++) {
                randomSequenceChar[i] = Character.forDigit(randomSequence[i], 10);
             }
      
          String randomSequenceString = String.valueOf(randomSequenceChar);
    
     
        String dummyRandomRegistration = randomYearString + randomBranchString + randomSequenceString;
        randomRegistration = dummyRandomRegistration;
     
          return randomRegistration;
    }
}

