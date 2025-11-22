package xyz.laria.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Enumeration;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class ZipUtils {
    public static String encrypt(String key, String string) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, secretKeySpec, new IvParameterSpec(new byte[16]));
            return Base64.getEncoder().encodeToString(cipher.doFinal(string.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception var4) {
            var4.printStackTrace();
            return "";
        }
    }

    public static String randomKey(int n) {
        return UUID.randomUUID().toString().substring(0, n);
    }

    public static String decryptSONOYUNCU(String string) {
        StringBuilder string2 = new StringBuilder();
        int n = string.length();

        for(int n2 = 0; n2 < n; ++n2) {
            char c = string.charAt(n2);
            c = (char)(c - 10);
            string2.append(c);
        }

        return new String(string2.toString().getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
    }

    public static void unzip1(String zipFilePath, File destDir) {
        try {
            byte[] buffer = new byte[1024];
            ZipInputStream zis = new ZipInputStream(Files.newInputStream(Paths.get(zipFilePath)));
            ZipEntry zipEntry = zis.getNextEntry();

            while(zipEntry != null) {
                for(; zipEntry != null; zipEntry = zis.getNextEntry()) {
                    File newFile = newFile(destDir, zipEntry);
                    if (zipEntry.isDirectory()) {
                        if (!newFile.isDirectory() && !newFile.mkdirs()) {
                            throw new IOException("Failed to create directory " + newFile);
                        }
                    } else {
                        File parent = newFile.getParentFile();
                        if (!parent.isDirectory() && !parent.mkdirs()) {
                            throw new IOException("Failed to create directory " + parent);
                        }

                        FileOutputStream fos = new FileOutputStream(newFile);

                        int len;
                        while((len = zis.read(buffer)) > 0) {
                            fos.write(buffer, 0, len);
                        }

                        fos.close();
                    }
                }
            }

            zis.closeEntry();
            zis.close();
        } catch (Exception var9) {
            var9.printStackTrace();
        }

    }

    public static File newFile(File destinationDir, ZipEntry zipEntry) throws IOException {
        File destFile = new File(destinationDir, zipEntry.getName());
        String destDirPath = destinationDir.getCanonicalPath();
        String destFilePath = destFile.getCanonicalPath();
        if (!destFilePath.startsWith(destDirPath + File.separator)) {
            throw new IOException("Entry is outside of the target dir: " + zipEntry.getName());
        } else {
            return destFile;
        }
    }

    public static void unzip(String zipFilePath, File destDir) {
        try {
            ZipFile file = new ZipFile(zipFilePath);
            Throwable var3 = null;

            try {
                Enumeration zipEntries = file.entries();

                while(true) {
                    while(zipEntries.hasMoreElements()) {
                        ZipEntry zipEntry = (ZipEntry)zipEntries.nextElement();
                        if (zipEntry.isDirectory()) {
                            String subDir = destDir + "\\" + zipEntry.getName();
                            File as = new File(subDir);
                            as.mkdirs();
                        } else {
                            File newFile = new File(destDir, zipEntry.getName());
                            String extractedDirectoryPath = destDir.getCanonicalPath();
                            String extractedFilePath = newFile.getCanonicalPath();
                            if (!extractedFilePath.startsWith(extractedDirectoryPath + File.separator)) {
                                throw new IOException("Entry is outside of the target dir: " + zipEntry.getName());
                            }

                            BufferedInputStream inputStream = new BufferedInputStream(file.getInputStream(zipEntry));
                            FileOutputStream outputStream = new FileOutputStream(newFile);
                            Throwable throwable = null;

                            try {
                                while(inputStream.available() > 0) {
                                    outputStream.write(inputStream.read());
                                }
                            } catch (Throwable var36) {
                                throwable = var36;
                                throw var36;
                            } finally {
                                if (outputStream != null) {
                                    if (throwable == null) {
                                        outputStream.close();
                                    } else {
                                        try {
                                            outputStream.close();
                                        } catch (Throwable var35) {
                                            throwable.addSuppressed(var35);
                                        }
                                    }
                                }
                                continue;
                            }
                        }
                    }

                    return;
                }
            } catch (Throwable var38) {
                var3 = var38;
                throw var38;
            } finally {
                if (file != null) {
                    if (var3 != null) {
                        try {
                            file.close();
                        } catch (Throwable var34) {
                            var3.addSuppressed(var34);
                        }
                    } else {
                        file.close();
                    }
                }

            }
        } catch (Exception var40) {
            var40.printStackTrace();
        }
    }
}
