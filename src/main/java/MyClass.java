import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MyClass {


    public static void main(String[] args) {
        String pathTarget = "C:\\Users\\xxxxxxxxxxx\\eclipse-workspace";
        String remTarget = "node_modules";

        Set<String> set = new HashSet<>();

        File dirTarget = new File(pathTarget);
        for (File file : Objects.requireNonNull(dirTarget.listFiles())) {
//            System.out.println(file.getAbsolutePath());
            List<File> collect = Arrays.stream(Objects.requireNonNull(file.listFiles())).filter(new Predicate<File>() {
                @Override
                public boolean test(File file) {
                    return file.getName().contains(remTarget);
                }
            }).collect(Collectors.toList());
            if (collect.size() ==1) {
                File pathNodemodule = collect.get(0);
                set.add(pathNodemodule.getAbsolutePath());
            }
        }
        for (String s : set) {
            File dir = new File(s);
            try {
                FileUtils.deleteDirectory(dir);
                System.out.println(dir.getAbsolutePath() + "delete done!!!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
