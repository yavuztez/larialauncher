package xyz.laria;

import java.security.AccessControlException;
import java.security.Permission;
import xyz.laria.utils.SoClassLoader;

public class SecurityM extends SecurityManager {
    public void checkExit(int n) {
        this.x("JVM kapatılamaz!");
    }

    public void checkAccess(ThreadGroup threadGroup) {
        this.x("Yetkisiz thread grup erişimi");
    }

    public void checkAccess(Thread thread) {
        this.x("Yetkisiz thread grup erişimi");
    }

    public void checkPermission(Permission permission, Object object) {
        this.checkPermission(permission);
    }

    public void checkPermission(Permission permission) {
        switch (permission.getName()) {
            case "setSecurityManager":
                throw new AccessControlException("Yetkisiz erişim.", permission);
            default:
        }
    }

    private void x(String string) {
        Class[] classArray = this.getClassContext();

        ClassLoader classLoader;
        for(int n = 0; n < classArray.length && (classLoader = classArray[n].getClassLoader()) != ClassLoader.getSystemClassLoader() && (classLoader != null || classArray[n].getName().startsWith("java")); ++n) {
            if (classLoader != null) {
                if (!classLoader.getClass().getName().equals(SoClassLoader.class.getName())) {
                    throw new AccessControlException("Yasak veya yetkisiz işlem. İşlem engelleme mesajı: " + string);
                }
                break;
            }
        }

    }
}
