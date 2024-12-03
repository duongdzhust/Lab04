package hust.soict.dsai.garbage;


public class ConcatenationInLoops {
    public static void main(String[] args) {
        int numIterations = 100000;
        
        // Test using the "+" operator (String concatenation)
        long startTime = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < numIterations; i++) {
            str += "test";
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken using '+' operator: " + (endTime - startTime) + " ms");

        // Test using StringBuilder
        startTime = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numIterations; i++) {
            stringBuilder.append("test");
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time taken using StringBuilder: " + (endTime - startTime) + " ms");

        // Test using StringBuffer
        startTime = System.currentTimeMillis();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < numIterations; i++) {
            stringBuffer.append("test");
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time taken using StringBuffer: " + (endTime - startTime) + " ms");
    }
}
