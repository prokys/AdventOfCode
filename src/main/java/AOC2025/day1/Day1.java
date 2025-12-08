package AOC2025.day1;

public class Day1 {

    static int startCode = 50;
    static int roll;

    public static int partOne(String[] inputList){
        int code = startCode;
        int finalNumber = 0;

        for (String input : inputList){
            code = countCode(input, code);
            code = fixOverFlow(code);
            if (code == 0) finalNumber++;
        }

       return finalNumber;
    }

    public static int partTwo(String[] inputList){
        int code = startCode;
        roll = 0;

        for (String input : inputList){
            code = countCode(input, code);
        }

        return roll;
    }


    public static int countCode(String input, int code){

        char direction = input.charAt(0);
        int clicks = Integer.parseInt(input.substring(1));
        int previous = code;

        switch (direction){
            case 'L':{
                code = code - clicks;
                if (code < 0){
                    code = fixOverFlow(code);
                    if (code == 0) roll++;
                    if (previous == 0) roll --;
                }else if(code==0) roll++;
                break;
            }
            case 'R':{
                code = code + clicks;
                if (code > 99){
                    code = fixOverFlow(code);
                }else if(code==0) roll++;
                break;
            }
        }
        return code;
    }

    public static int fixOverFlow(int input){
        do {
            roll++;
        if (input < 0) input = input+100;
        else if (input > 99) input = input-100;
        }while (input < 0 || input > 99);
        return input;
    }



}
