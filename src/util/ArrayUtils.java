package util;

public class ArrayUtils {

    public int[] getIntegerArray(String string) {
        int length = string.length();
        if (length == 0) {
            return new int[]{};
        }
        String data = string.substring(1, string.length() - 1);
        String[] dataArray = data.split(",");

        int[] array = new int[dataArray.length];
        for (int i = 0; i < dataArray.length; i++) {
            array[i] = Integer.valueOf(dataArray[i]);
        }
        return array;
    }


}
