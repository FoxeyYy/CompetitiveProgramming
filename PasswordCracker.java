import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    // We keep a set of failed tracks, 
    // so whenever we got with a shorter loginAttempt that has been previously reached
    // we know that our current path is going to end on a "WRONG PASSWORD"
    public static boolean passwordCracker(
            List<String> passwords, 
            String loginAttempt, 
            Set<String> failed,
            LinkedList<String> result) {

        if (loginAttempt.isEmpty()) return true;
        if (failed.contains(loginAttempt)) return false;

        for(String password: passwords){
            if (loginAttempt.startsWith(password)) {
                failed.add(loginAttempt);
                result.add(password);
                if (passwordCracker(passwords, loginAttempt.substring(password.length()), failed, result)) return true;

                result.removeLast();
            }
        }

        return false;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<String> passwords = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .collect(toList());

                String loginAttempt = bufferedReader.readLine();

                LinkedList<String> result = new LinkedList<>();

                Result.passwordCracker(passwords, loginAttempt, new HashSet<>(), result);

                if (result.isEmpty()) {
                    bufferedWriter.write("WRONG PASSWORD");
                } else {
                    bufferedWriter.write(String.join(" ", result));
                }

                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
