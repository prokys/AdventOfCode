package AOC2023.day3;

import AOC2023.utils.Utils;

import java.util.ArrayList;

public class Day3 {
    public static ArrayList<String> inputArrayList = Utils.readFileAndStoreValues("src\\main\\java\\AOC2023\\day3\\input.txt");
    public static int finalNumber= 0;
    public static int finalNumberPartTwo = 0;
    public static void main(String args[]){
        partOne();
        partTwo();
    }

    public static void partTwo(){
        String inputArray[] = inputArrayList.toArray(new String[0]);
        for(int y=0;y<inputArray.length;y++) {
            StringBuilder stringBuilder = new StringBuilder(inputArray[y]);
            for (int i = 0; i < stringBuilder.length(); i++) {
                if (stringBuilder.charAt(i)=='*') {
                    ArrayList<String> numbersAroundStar= new ArrayList<>();
                    for (int z = i - 1; z <= i + 1; z++) {
                        StringBuilder number = new StringBuilder();
                        for (int c = y - 1; c <= y + 1; c++) {
                            if (z >= 0 && c >= 0 && z < stringBuilder.length() && c < inputArray.length) {
                                StringBuilder stringToCheck = new StringBuilder(inputArray[c]);
                                if (z < stringToCheck.length() - 2 && Character.isDigit(stringToCheck.charAt(z)) && Character.isDigit(stringToCheck.charAt(z + 1)) && Character.isDigit(stringToCheck.charAt(z + 2))) {
                                    number.append(stringToCheck.charAt(z));
                                    number.append(stringToCheck.charAt(z + 1));
                                    number.append(stringToCheck.charAt(z + 2));
                                    numbersAroundStar.add(number.toString());
                                    number.delete(0,3);
                                }else if (z > 0 && i < stringToCheck.length() - 1 && !Character.isDigit(stringToCheck.charAt(z - 1)) && Character.isDigit(stringToCheck.charAt(z)) && Character.isDigit(stringToCheck.charAt(z + 1)) && !Character.isDigit(stringToCheck.charAt(z + 2))) {
                                    number.append(stringToCheck.charAt(z));
                                    number.append(stringToCheck.charAt(z + 1));
                                    numbersAroundStar.add(number.toString());
                                    number.delete(0,2);
                                }else if (z > 0 && !Character.isDigit(stringToCheck.charAt(z - 1)) && Character.isDigit(stringToCheck.charAt(z)) && !Character.isDigit(stringToCheck.charAt(z + 1))) {
                                    number.append(stringToCheck.charAt(z));
                                    numbersAroundStar.add(number.toString());
                                    number.delete(0,1);
                                }else if (((z==i-1) ||(z==i)) && Character.isDigit(stringToCheck.charAt(z)) && Character.isDigit(stringToCheck.charAt(z-1)) && Character.isDigit(stringToCheck.charAt(z - 2))) {
                                    number.append(stringToCheck.charAt(z - 2));
                                    number.append(stringToCheck.charAt(z - 1));
                                    number.append(stringToCheck.charAt(z));
                                    numbersAroundStar.add(number.toString());
                                    number.delete(0,3);
                                }else if (z ==i-1 && !Character.isDigit(stringToCheck.charAt(z + 1)) && Character.isDigit(stringToCheck.charAt(z)) && Character.isDigit(stringToCheck.charAt(z - 1)) && !Character.isDigit(stringToCheck.charAt(z - 2))) {
                                    number.append(stringToCheck.charAt(z - 1));
                                    number.append(stringToCheck.charAt(z));
                                    numbersAroundStar.add(number.toString());
                                    number.delete(0,2);
                                }
                            }
                        }
                    }
                    if(numbersAroundStar.size() == 2){
                        finalNumberPartTwo = finalNumberPartTwo + (Integer.parseInt(numbersAroundStar.get(0)) * Integer.parseInt(numbersAroundStar.get(1)));
                    }
                }
            }
        }
        System.out.println(finalNumberPartTwo);

    }
    public static void partOne(){

        String inputArray[] = inputArrayList.toArray(new String[0]);
        for(int y=0;y<inputArray.length;y++) {
            StringBuilder stringBuilder = new StringBuilder(inputArray[y]);
            for (int i = 0; i < stringBuilder.length(); i++) {
                StringBuilder number = new StringBuilder();
                if (i < stringBuilder.length() - 2 && Character.isDigit(stringBuilder.charAt(i)) && Character.isDigit(stringBuilder.charAt(i + 1)) && Character.isDigit(stringBuilder.charAt(i + 2))) {
                    number.append(stringBuilder.charAt(i));
                    number.append(stringBuilder.charAt(i + 1));
                    number.append(stringBuilder.charAt(i + 2));
                    Boolean isThereSpecialCharacter = false;

                    for (int z = i - 1; z <= i + 3; z++) {
                        for (int c = y - 1; c <= y + 1; c++) {
                            if (z >= 0 && c >= 0 && z < stringBuilder.length() && c < inputArray.length) {
                                StringBuilder stringToCheck = new StringBuilder(inputArray[c]);
                                if (stringToCheck.charAt(z) != '.' && !Character.isDigit(stringToCheck.charAt(z))) {
                                    isThereSpecialCharacter = true;
                                }
                            }
                        }
                    }
                    if(isThereSpecialCharacter == true){
                        finalNumber = finalNumber + Integer.parseInt(number.toString());
                    }

                } else if (i > 0 && i < stringBuilder.length() - 1 && !Character.isDigit(stringBuilder.charAt(i - 1)) && Character.isDigit(stringBuilder.charAt(i)) && Character.isDigit(stringBuilder.charAt(i + 1)) && !Character.isDigit(stringBuilder.charAt(i + 2))) {
                    number.append(stringBuilder.charAt(i));
                    number.append(stringBuilder.charAt(i + 1));
                    Boolean isThereSpecialCharacter = false;

                    for (int z=i-1; z<=i + 2; z++) {
                        for (int c = y - 1; c <= y + 1; c++) {
                            if (z >= 0 && c >= 0 && z < stringBuilder.length() && c < inputArray.length) {
                                StringBuilder stringToCheck = new StringBuilder(inputArray[c]);
                                if (stringToCheck.charAt(z) != '.' && !Character.isDigit(stringToCheck.charAt(z))) {
                                    isThereSpecialCharacter = true;
                                }
                            }
                        }
                    }
                    if(isThereSpecialCharacter == true){
                        finalNumber = finalNumber + Integer.parseInt(number.toString());
                    }
                } else if (i > 0 && !Character.isDigit(stringBuilder.charAt(i - 1)) && Character.isDigit(stringBuilder.charAt(i)) && !Character.isDigit(stringBuilder.charAt(i + 1))) {
                    number.append(stringBuilder.charAt(i));
                    Boolean isThereSpecialCharacter = false;

                    for (int z=i-1; z<=i+1; z++) {
                        for (int c = y - 1; c <= y + 1; c++) {
                            if (z >= 0 && c >= 0 && z < stringBuilder.length() && c < inputArray.length) {
                                StringBuilder stringToCheck = new StringBuilder(inputArray[c]);
                                if (stringToCheck.charAt(z) != '.' && !Character.isDigit(stringToCheck.charAt(z))) {
                                    isThereSpecialCharacter = true;
                                }
                            }
                        }
                    }
                    if(isThereSpecialCharacter == true){
                        finalNumber = finalNumber + Integer.parseInt(number.toString());
                    }
                }

            }
        }
        System.out.println(finalNumber);

//            System.out.println(stringBuilder);
//        System.out.println(inputArray[0]);
//        Utils.printArray(inputArray);

    }
}
