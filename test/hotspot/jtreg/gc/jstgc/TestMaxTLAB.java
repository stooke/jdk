/*
 * Copyright (c) 2018, Red Hat, Inc. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package gc.jstgc;

/**
 * @test TestMaxTLAB
 * @requires vm.gc.Jstgc
 * @summary Check JstgcMaxTLAB options
 * @bug 8212177
 *
 * @run main/othervm -Xmx64m
 *                   -XX:+UnlockExperimentalVMOptions -XX:+UseJstgcGC
 *                   -XX:JstgcMaxTLABSize=1
 *                   gc.jstgc.TestMaxTLAB
 *
 * @run main/othervm -Xmx64m
 *                   -XX:+UnlockExperimentalVMOptions -XX:+UseJstgcGC
 *                   -XX:JstgcMaxTLABSize=1K
 *                   gc.jstgc.TestMaxTLAB
 *
 * @run main/othervm -Xmx64m
 *                   -XX:+UnlockExperimentalVMOptions -XX:+UseJstgcGC
 *                   -XX:JstgcMaxTLABSize=1M
 *                   gc.jstgc.TestMaxTLAB
 *
 * @run main/othervm -Xmx64m
 *                   -XX:+UnlockExperimentalVMOptions -XX:+UseJstgcGC
 *                   -XX:JstgcMaxTLABSize=12345
 *                   gc.jstgc.TestMaxTLAB
 */

/**
 * @test TestMaxTLAB
 * @requires vm.gc.Jstgc
 * @requires vm.bits == "64"
 * @summary Check JstgcMaxTLAB options
 * @bug 8212177
 * @run main/othervm -Xmx64m
 *                   -XX:+UnlockExperimentalVMOptions -XX:+UseJstgcGC
 *                   -XX:JstgcMaxTLABSize=1
 *                   -XX:ObjectAlignmentInBytes=16
 *                   gc.jstgc.TestMaxTLAB
 *
 * @run main/othervm -Xmx64m
 *                   -XX:+UnlockExperimentalVMOptions -XX:+UseJstgcGC
 *                   -XX:JstgcMaxTLABSize=1K
 *                   -XX:ObjectAlignmentInBytes=16
 *                   gc.jstgc.TestMaxTLAB
 *
 * @run main/othervm -Xmx64m
 *                   -XX:+UnlockExperimentalVMOptions -XX:+UseJstgcGC
 *                   -XX:JstgcMaxTLABSize=1M
 *                   -XX:ObjectAlignmentInBytes=16
 *                   gc.jstgc.TestMaxTLAB
 *
 * @run main/othervm -Xmx64m
 *                   -XX:+UnlockExperimentalVMOptions -XX:+UseJstgcGC
 *                   -XX:JstgcMaxTLABSize=12345
 *                   -XX:ObjectAlignmentInBytes=16
 *                   gc.jstgc.TestMaxTLAB
 */

public class TestMaxTLAB {
    static Object sink;

    public static void main(String[] args) throws Exception {
        for (int c = 0; c < 1000; c++) {
            sink = new byte[c];
        }
    }
}
