import java.io.*;
import java.util.*;

public class FileSplitter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {

            System.out.print("Masukkan path file teks: ");
            String filePath = scanner.nextLine();

            File file = new File(filePath);
            BufferedReader reader = new BufferedReader(new FileReader(file));


            System.out.print("Masukkan jumlah bagian yang ingin dibuat: ");
            int parts = scanner.nextInt();
            scanner.nextLine();


            Queue<String> queue = new LinkedList<>();

            String line;
            while ((line = reader.readLine()) != null) {
                queue.add(line);
            }
            reader.close();

            int totalLines = queue.size();
            int linesPerPart = (int) Math.ceil(totalLines / (double) parts);

            System.out.println("Total baris: " + totalLines);
            System.out.println("Baris per bagian: " + linesPerPart);


            for (int i = 1; i <= parts; i++) {
                String outputName = "output_part_" + i + ".txt";
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputName));

                int count = 0;
                while (!queue.isEmpty() && count < linesPerPart) {
                    writer.write(queue.poll());
                    writer.newLine();
                    count++;
                }

                writer.close();
                System.out.println("Bagian ke-" + i + " disimpan sebagai: " + outputName);
            }

            System.out.println("Selesai memotong file!");

        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
}
