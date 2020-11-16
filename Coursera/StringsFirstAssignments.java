package Coursera;

class Part1{
    public String findGeneSimple(String dna){
        String result ="";
        if(dna.length()%3!=0){
            return "";
        }
        int startIndex=dna.indexOf("ATG");
        if(startIndex==-1){
            return "";
        }
        int stopIndex=dna.indexOf("TAA",startIndex+3);
        if(stopIndex==-1){
            return "";
        }
        result=dna.substring(startIndex,stopIndex+3);
        return result;
    }

    public void testSimpleGene(){
        String dna = "ASWFSDATGWERGDFWTFCSDTAAQWEFDSXCG";
        String result = findGeneSimple(dna);
        System.out.println("The main thing of: "+dna+" is: "+result);
    }
}

public class StringsFirstAssignments {
    public static void main(String[] args) {
        Part2 test=new Part2();
        test.testing();
    }
}

class Part2{
    public String findGeneSimple(String dna){
        if(dna.equals(dna.toUpperCase())){
            String result ="";
            if(dna.length()%3!=0){
                return "";
            }

            String startCodon = "ATG";
            String stopCodon = "TAA";
            int startIndex=dna.indexOf(startCodon);
            if(startIndex==-1){
                return "";
            }
            int stopIndex=dna.indexOf(stopCodon,startIndex+3);
            if(stopIndex==-1){
                return "";
            }
            result=dna.substring(startIndex,stopIndex+3);
            return result;
        }else {
            String result ="";
            if(dna.length()%3!=0){
                return "";
            }

            String startCodon = "atg";
            String stopCodon = "taa";
            int startIndex=dna.indexOf(startCodon);
            if(startIndex==-1){
                return "";
            }
            int stopIndex=dna.indexOf(stopCodon,startIndex+3);
            if(stopIndex==-1){
                return "";
            }
            result=dna.substring(startIndex,stopIndex+3);
            return result;
        }

    }

    public boolean twoOccurrences(String stringa, String stringb){
        int startIndex,checkIndex;
        startIndex=stringb.indexOf(stringa);
        if(startIndex==-1){
            return false;
        }else{
            checkIndex=stringb.indexOf(stringa,startIndex+stringa.length());
            if(checkIndex==-1){
                return false;
            }else {
                return true;
            }
        }

    }

    public String lastpart(String stringa, String stringb){
        int startIndex, checkIndex;
        startIndex=stringb.indexOf(stringa);
        String sub;
        if(startIndex==-1){
            return stringb;
        }else{
            sub=stringb.substring(startIndex+stringa.length(),stringb.length());
            return sub;
        }
    }

    public void testing(){
        String stringb= "A story by Abby Long";
        String stringa="by";
        boolean result=twoOccurrences(stringa,stringb);
        System.out.println("The result is: "+result);

        stringb= "ctgtatgta";
        stringa="atg";
        result=twoOccurrences(stringa,stringb);
        System.out.println("The result is: "+result);

        stringb= "banana";
        stringa="a";
        result=twoOccurrences(stringa,stringb);
        System.out.println("The result is: "+result);

         stringa="an";
         stringb="banana";
         String sub = lastpart(stringa,stringb);
         System.out.println("The result is: "+sub);

         stringa="zoo";
         stringb="forest";
         sub=lastpart(stringa,stringb);
         System.out.println("The result is: "+sub);

    }
    public void testSimpleGene(){
        String dna = "ASWFSDATGWERGDFWTFCSDTAAQWEFDSXCG";
        String result = findGeneSimple(dna);
        System.out.println("The main thing of: "+dna+" is: "+result);
        dna = "qweatgasdfghjkltaaasdfghjkl";
        result = findGeneSimple(dna);
        System.out.println("The main thing of: "+dna+" is: "+result);
    }
}

class part4{
    public void findLinks(){

    }
}