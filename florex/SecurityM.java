/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package xyz.florex;

import java.security.AccessControlException;
import java.security.Permission;
import xyz.florex.utils.SoClassLoader;

public class SecurityM
extends SecurityManager {
    @Override
    public void checkExit(int n) {
        this.x("JVM kapat\u0131lamaz!");
    }

    @Override
    public void checkAccess(ThreadGroup threadGroup) {
        this.x("Yetkisiz thread grup eri\u015fimi");
    }

    @Override
    public void checkAccess(Thread thread) {
        this.x("Yetkisiz thread grup eri\u015fimi");
    }

    @Override
    public void checkPermission(Permission permission, Object object) {
        this.checkPermission(permission);
    }

    @Override
    public void checkPermission(Permission permission) {
        switch (permission.getName()) {
            case "setSecurityManager": {
                throw new AccessControlException("Yetkisiz eri\u015fim.", permission);
            }
        }
    }

    private void x(String string) {
        ClassLoader classLoader;
        Class[] classArray = this.getClassContext();
        for (int n = 0; n < classArray.length && (classLoader = classArray[n].getClassLoader()) != ClassLoader.getSystemClassLoader() && (classLoader != null || classArray[n].getName().startsWith("java")); ++n) {
            if (classLoader == null) continue;
            if (classLoader.getClass().getName().equals(SoClassLoader.class.getName())) break;
            throw new AccessControlException("Yasak veya yetkisiz i\u015flem. \u0130\u015flem engelleme mesaj\u0131: " + string);
        }
    }
}

