package com.devbeans.io.chat.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u00f4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 \u00de\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0002\u00de\u0001B\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010O\u001a\u00020\u00182\u0006\u0010P\u001a\u00020/H\u0002J\u0018\u0010Q\u001a\u00020\u00182\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020\u001cH\u0002J\u0006\u0010U\u001a\u00020\u0018J\b\u0010V\u001a\u00020\u0018H\u0002J\u0010\u0010W\u001a\u00020\u00182\u0006\u0010X\u001a\u00020(H\u0002J\b\u0010Y\u001a\u00020\u0018H\u0002J\b\u0010Z\u001a\u00020\u0018H\u0002J\u0018\u0010[\u001a\u00020\u00182\u0006\u0010\\\u001a\u00020\u000f2\u0006\u0010]\u001a\u00020\bH\u0002J\b\u0010^\u001a\u00020\u0018H\u0002J\n\u0010_\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010_\u001a\u0004\u0018\u00010\b2\u0006\u0010\\\u001a\u00020\u000fH\u0002J\u0010\u0010`\u001a\u00020\b2\u0006\u0010\\\u001a\u00020\u000fH\u0002J\b\u0010a\u001a\u00020\u0018H\u0002J\b\u0010b\u001a\u00020\u0018H\u0002J\b\u0010c\u001a\u00020\u0018H\u0002J\b\u0010d\u001a\u00020\u0018H\u0002J\u0012\u0010e\u001a\u00020\u00182\b\u0010f\u001a\u0004\u0018\u00010gH\u0002J\u0012\u0010h\u001a\u00020\u00182\b\u0010f\u001a\u0004\u0018\u00010gH\u0002J\u0012\u0010i\u001a\u00020\u00182\b\u0010f\u001a\u0004\u0018\u00010gH\u0002J\u0012\u0010j\u001a\u00020\u00182\b\u0010f\u001a\u0004\u0018\u00010gH\u0002J\b\u0010k\u001a\u00020\u0018H\u0002J\u0012\u0010l\u001a\u00020\u00182\b\u0010f\u001a\u0004\u0018\u00010gH\u0002J\u0012\u0010m\u001a\u00020\u00182\b\u0010X\u001a\u0004\u0018\u00010(H\u0002J\u0010\u0010n\u001a\u00020\u00182\u0006\u0010X\u001a\u00020(H\u0002J\u0014\u0010o\u001a\u00020\u00182\n\u0010p\u001a\u0006\u0012\u0002\b\u00030qH\u0002J\u0010\u0010r\u001a\u00020\u00182\u0006\u0010s\u001a\u00020tH\u0002J\u0010\u0010u\u001a\u00020\u00182\u0006\u0010X\u001a\u00020(H\u0002J\b\u0010v\u001a\u00020\u0018H\u0002J\b\u0010w\u001a\u00020\u0018H\u0002J\u0012\u0010x\u001a\u00020\u00182\b\u0010f\u001a\u0004\u0018\u00010gH\u0002J\u0010\u0010y\u001a\u00020\u00182\u0006\u0010X\u001a\u00020(H\u0002J\u0012\u0010z\u001a\u00020\u00182\b\u0010f\u001a\u0004\u0018\u00010gH\u0002J\u0012\u0010{\u001a\u00020\u00182\b\u0010f\u001a\u0004\u0018\u00010gH\u0002J\u0012\u0010|\u001a\u00020\u00182\b\u0010f\u001a\u0004\u0018\u00010gH\u0002J\u0010\u0010}\u001a\u00020\u00182\u0006\u0010X\u001a\u00020(H\u0002J\u0012\u0010~\u001a\u00020\u00182\b\u0010f\u001a\u0004\u0018\u00010gH\u0002J\u0012\u0010\u007f\u001a\u00020\u00182\b\u0010f\u001a\u0004\u0018\u00010gH\u0002J-\u0010\u0080\u0001\u001a\u00020\u00182\n\u0010p\u001a\u0006\u0012\u0002\b\u00030q2\u0016\u0010\u0081\u0001\u001a\u0011\u0012\u0006\u0012\u0004\u0018\u00010g\u0012\u0004\u0012\u00020\u00180\u0082\u0001H\u0002J\t\u0010\u0083\u0001\u001a\u00020\u0018H\u0002J\t\u0010\u0084\u0001\u001a\u00020\u0018H\u0002J$\u0010\u0085\u0001\u001a\u00020\u00182\u0006\u0010\\\u001a\u00020\u000f2\u0006\u0010]\u001a\u00020\b2\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\bH\u0002J\u0013\u0010\u0087\u0001\u001a\u00020\u00182\b\u0010f\u001a\u0004\u0018\u00010gH\u0002J\u0013\u0010\u0088\u0001\u001a\u00020\u00182\b\u0010f\u001a\u0004\u0018\u00010gH\u0002J\u0013\u0010\u0089\u0001\u001a\u00020\u00182\b\u0010f\u001a\u0004\u0018\u00010gH\u0002J#\u0010\u008a\u0001\u001a\u00020\u00182\u0007\u0010\u008b\u0001\u001a\u00020\u00162\u0007\u0010\u008c\u0001\u001a\u00020/2\u0006\u0010P\u001a\u00020/H\u0002J\u0015\u0010\u008d\u0001\u001a\u00020\u00182\n\u0010p\u001a\u0006\u0012\u0002\b\u00030qH\u0002J\t\u0010\u008e\u0001\u001a\u00020\u0018H\u0002J\u0011\u0010\u008f\u0001\u001a\u00020\u00182\u0006\u0010X\u001a\u00020(H\u0002J\t\u0010\u0090\u0001\u001a\u00020\u0018H\u0002J\u0007\u0010\u0091\u0001\u001a\u00020\u0018J\u0011\u0010\u0092\u0001\u001a\u00020\u00182\u0006\u0010T\u001a\u00020\u001cH\u0002J\t\u0010\u0093\u0001\u001a\u00020\u0018H\u0002J\u0013\u0010\u0094\u0001\u001a\u00020\u00182\b\u0010\u0095\u0001\u001a\u00030\u0096\u0001H\u0002J\u0011\u0010\u0097\u0001\u001a\u00020\u00182\u0006\u0010\\\u001a\u00020\u000fH\u0002J\u0011\u0010\u0098\u0001\u001a\u00020\u00182\u0006\u0010\\\u001a\u00020\u000fH\u0002J\u0011\u0010\u0099\u0001\u001a\u00020\u00182\u0006\u0010\\\u001a\u00020\u000fH\u0002J\u0011\u0010\u009a\u0001\u001a\u00020\u00182\u0006\u0010\\\u001a\u00020\u000fH\u0002J\u0011\u0010\u009b\u0001\u001a\u00020\u00182\u0006\u0010\\\u001a\u00020\u000fH\u0002J\u0011\u0010\u009c\u0001\u001a\u00020\u00182\u0006\u0010\\\u001a\u00020\u000fH\u0002J\t\u0010\u009d\u0001\u001a\u00020\u0018H\u0016J\t\u0010\u009e\u0001\u001a\u00020\u0018H\u0002J\'\u0010\u009f\u0001\u001a\u00020\u00182\u0007\u0010\u00a0\u0001\u001a\u00020\u001c2\u0007\u0010\u00a1\u0001\u001a\u00020\u001c2\n\u0010\u00a2\u0001\u001a\u0005\u0018\u00010\u00a3\u0001H\u0017J\u0015\u0010\u00a4\u0001\u001a\u00020\u00182\n\u0010\u00a5\u0001\u001a\u0005\u0018\u00010\u00a6\u0001H\u0015J\t\u0010\u00a7\u0001\u001a\u00020\u0018H\u0014J,\u0010\u00a8\u0001\u001a\u00020\u00182\u000e\u0010\u00a9\u0001\u001a\t\u0012\u0002\b\u0003\u0018\u00010\u00aa\u00012\u0007\u0010p\u001a\u00030\u00ab\u00012\b\u0010\u00ac\u0001\u001a\u00030\u0096\u0001H\u0016J\u001a\u0010\u00ad\u0001\u001a\u00020\u00182\u0006\u0010R\u001a\u00020S2\u0007\u0010\u00ae\u0001\u001a\u00020\bH\u0016J\u001b\u0010\u00af\u0001\u001a\u00020\u00182\u0007\u0010\u00b0\u0001\u001a\u00020S2\u0007\u0010\u00ae\u0001\u001a\u00020\bH\u0016J\u0013\u0010\u00b1\u0001\u001a\u00020\u00162\b\u0010\u00b2\u0001\u001a\u00030\u00b3\u0001H\u0017J\t\u0010\u00b4\u0001\u001a\u00020\u0018H\u0014J/\u0010\u00b5\u0001\u001a\u00020\u00182\u000e\u0010\u00a9\u0001\u001a\t\u0012\u0002\b\u0003\u0018\u00010\u00aa\u00012\n\u0010p\u001a\u0006\u0012\u0002\b\u00030q2\b\u0010\u00ac\u0001\u001a\u00030\u0096\u0001H\u0016J\t\u0010\u00b6\u0001\u001a\u00020\u0018H\u0002J\t\u0010\u00b7\u0001\u001a\u00020\u0018H\u0002J\t\u0010\u00b8\u0001\u001a\u00020\u0018H\u0002J\u0012\u0010\u00b9\u0001\u001a\u00020\u00182\u0007\u0010\u00b0\u0001\u001a\u00020SH\u0002J\t\u0010\u00ba\u0001\u001a\u00020\u0018H\u0002J\u0013\u0010\u00bb\u0001\u001a\u00020\u00182\b\u0010\u00bc\u0001\u001a\u00030\u00bd\u0001H\u0002J\t\u0010\u00be\u0001\u001a\u00020\u0018H\u0002J\u0011\u0010\u00bf\u0001\u001a\u00020\u00182\u0006\u0010T\u001a\u00020\u001cH\u0002J\t\u0010\u00c0\u0001\u001a\u00020\u0018H\u0002J\t\u0010\u00c1\u0001\u001a\u00020\u0018H\u0004J\t\u0010\u00c2\u0001\u001a\u00020\u0018H\u0002J\u001a\u0010\u00c3\u0001\u001a\u00020\u00182\u0006\u0010R\u001a\u00020S2\u0007\u0010\u00ae\u0001\u001a\u00020\bH\u0003J\t\u0010\u00c4\u0001\u001a\u00020\u0018H\u0002J\u0012\u0010\u00c5\u0001\u001a\u00020\u00182\u0007\u0010\u00c6\u0001\u001a\u00020\bH\u0002J\t\u0010\u00c7\u0001\u001a\u00020\u0018H\u0002J\u0013\u0010\u00c8\u0001\u001a\u00020\u00182\n\u0010\u00c9\u0001\u001a\u0005\u0018\u00010\u00ca\u0001J\u0012\u0010\u00cb\u0001\u001a\u00020\u00182\u0007\u0010\u00cc\u0001\u001a\u00020\u0016H\u0002J\t\u0010\u00cd\u0001\u001a\u00020\u0018H\u0002J\u0012\u0010\u00ce\u0001\u001a\u00020\u00182\u0007\u0010\u00cc\u0001\u001a\u00020\u0016H\u0002J\u0011\u0010\u00cf\u0001\u001a\u00020\u00182\u0006\u0010\\\u001a\u00020\u000fH\u0002J$\u0010\u00d0\u0001\u001a\u00020\u00182\u0006\u0010\\\u001a\u00020\u000f2\u0006\u0010]\u001a\u00020\b2\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\bH\u0002J\u001c\u0010\u00d1\u0001\u001a\u00020\u00182\u0006\u0010\\\u001a\u00020\u000f2\t\u0010\u00d2\u0001\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010\u00d3\u0001\u001a\u00020\u00182\u0007\u0010\u00d4\u0001\u001a\u00020\u0016H\u0002J\t\u0010\u00d5\u0001\u001a\u00020\u0018H\u0002J\u0012\u0010\u00d6\u0001\u001a\u00020\u00182\u0007\u0010\u00cc\u0001\u001a\u00020\u0016H\u0002J\t\u0010\u00d7\u0001\u001a\u00020\u0018H\u0002J\u0013\u0010\u00d7\u0001\u001a\u00020\u00182\b\u0010]\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010\u00d8\u0001\u001a\u00020\u00182\u0007\u0010\u00cc\u0001\u001a\u00020\u0016H\u0002J\t\u0010\u00d9\u0001\u001a\u00020\u0018H\u0002J\u0012\u0010\u00da\u0001\u001a\u00020\u00182\u0007\u0010\u00cc\u0001\u001a\u00020\u0016H\u0002J\u0011\u0010\u00db\u0001\u001a\u00020\u00182\u0006\u0010\\\u001a\u00020\u000fH\u0002J\u0012\u0010\u00dc\u0001\u001a\u00020\u00182\u0007\u0010\u00dd\u0001\u001a\u00020\bH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u00188BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00160\"\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010#R\u000e\u0010$\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\'\u001a\u0004\u0018\u00010(X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0010\u0010-\u001a\u0004\u0018\u00010&X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u00100\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0011\"\u0004\b2\u0010\u0013R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000104X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000104X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\"\u0010>\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0?X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001c\u0010D\u001a\u0004\u0018\u00010EX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u0010\u0010J\u001a\u0004\u0018\u00010KX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010L\u001a\u0004\u0018\u00010EX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bM\u0010G\"\u0004\bN\u0010I\u00a8\u0006\u00df\u0001"}, d2 = {"Lcom/devbeans/io/chat/activities/ChatDetailsActivity;", "Lcom/devbeans/io/chat/verifypin/BaseActivity;", "Lcom/devbeans/io/chat/network/OnNetworkResponse;", "Lcom/devbeans/io/chat/callBacks/OnLongMemberCallback;", "Lcom/devbeans/io/chat/callBacks/OnMembersCallback;", "Lcom/devbeans/io/chat/callBacks/ExpiryCallback;", "()V", "BLOCK", "", "CHANGE_OWNER", "CLEAR", "DELETE", "DELETE_GROUP", "LEAVE_GROUP", "NewConversation", "Lcom/devbeans/io/chat/models/Conversation;", "getNewConversation", "()Lcom/devbeans/io/chat/models/Conversation;", "setNewConversation", "(Lcom/devbeans/io/chat/models/Conversation;)V", "UNBLOCK", "addedByQr", "", "chatDetails", "", "getChatDetails", "()Lkotlin/Unit;", "conversation_pk", "", "isAdmin", "()Z", "setAdmin", "(Z)V", "isCleared", "Landroidx/lifecycle/MutableLiveData;", "()Landroidx/lifecycle/MutableLiveData;", "isOwner", "mAddContact", "Landroidx/appcompat/widget/AppCompatButton;", "mBinding", "Lcom/devbeans/io/chat/databinding/ActivityChatDetailsBinding;", "getMBinding", "()Lcom/devbeans/io/chat/databinding/ActivityChatDetailsBinding;", "setMBinding", "(Lcom/devbeans/io/chat/databinding/ActivityChatDetailsBinding;)V", "mCancel", "mContact", "Lcom/devbeans/io/chat/models/Contact;", "mConversation", "getMConversation", "setMConversation", "mCreateDialog", "Landroidx/appcompat/app/AlertDialog;", "mDialog", "mDialogViewRemove", "mImageAdapter", "Lcom/devbeans/io/chat/adapters/ImageAdapter;", "mIsContact", "mIsOneToOne", "mMembersAdapter", "Lcom/devbeans/io/chat/adapters/GroupMemberAdapter;", "memberAdded", "memberList", "Ljava/util/ArrayList;", "getMemberList", "()Ljava/util/ArrayList;", "setMemberList", "(Ljava/util/ArrayList;)V", "nameEdit", "Lcom/google/android/material/textfield/TextInputEditText;", "getNameEdit", "()Lcom/google/android/material/textfield/TextInputEditText;", "setNameEdit", "(Lcom/google/android/material/textfield/TextInputEditText;)V", "payload", "Lcom/devbeans/io/chat/models/Payload;", "userIdEdit", "getUserIdEdit", "setUserIdEdit", "addMember", "contact", "addRemoveAdmin", "member", "Lcom/devbeans/io/chat/models/ConversationMember;", "i", "adminMemberChange", "checkAdmin", "clearAndLeaveGroup", "binding", "clearChat", "createSymmetricHandshakeIfNeeded", "deleteAndResetChannels", "conversation", "moniker", "dismissDialogs", "getConversationPhotoPath", "getMoniker", "handTvTotalClick", "handleAddContact", "handleAddContactClick", "handleAddMember", "handleAdminAssignedAnonymousResponse", "res", "Lcom/devbeans/io/chat/network/serializers/response/NewConversationResponse;", "handleAdminAssignedGroupResponse", "handleAdminRemovedAnonymousResponse", "handleAdminRemovedGroupResponse", "handleConversationIcon", "handleDestroyConversationResponse", "handleDetailsEditOption", "handleFadeOptions", "handleFailure", "response", "Lretrofit2/Response;", "handleGroupAddApi", "request", "Lcom/devbeans/io/chat/network/serializers/requestbody/AddMembersConversationRequest;", "handleGroupOptions", "handleGroupVisibilityOptions", "handleLeaveGroup", "handleLeaveGroupResponse", "handleLeaveText", "handleMemberAddedAnonymousResponse", "handleMemberAddedGroupResponse", "handleMemberAddedResponse", "handleReadReceiptsViews", "handleRemoveMemberAnonymousResponse", "handleRemoveMemberGroupResponse", "handleResponse", "onSuccessHandler", "Lkotlin/Function1;", "handleTvDescriptionClick", "handleTvTotalCountClick", "handleUIUpdates", "conversationPhotoPath", "handleUpdateConfidentialResponse", "handleUpdateMediaRestrictResponse", "handleUpdateViewOnceResponse", "handleUpdatingContacts", "hasContact", "existedContact", "handleVerifyUserResponse", "handleVisibilityOptions", "hideMediaUI", "initDialog", "initViews", "leaveGroup", "listeners", "loadConversationIcon", "icon", "", "logConversationDetails", "logRemoveMemberDetails", "logResponse", "logUpdateConfidentialResponse", "logUpdateMediaRestrictResponse", "logUpdateViewOnceResponse", "notifyExpiry", "observers", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFailure", "call", "Lretrofit2/Call;", "Lcom/devbeans/io/chat/network/serializers/response/BaseResponse;", "tag", "onLongMemberCallback", "name", "onMemberCallback", "id", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onResume", "onSuccess", "openMembersActivity", "populateMembers", "populateRecyclerView", "removeMember", "setMembersName", "setToolBar", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "showChangeNickNameDialog", "showCustomDialog", "showDeleteGroupDialog", "showLoadingDialog", "showMedia", "showViewRemoveDialog", "startDetailsEditActivity", "startDisappearingActivity", "option", "startMediaDetailsActivity", "startObserver", "img_file", "Ljava/io/File;", "updateAutoSaveToVault", "isChecked", "updateChatActivityInstance", "updateConfidential", "updateConfidentialSetting", "updateConversation", "updateConversationProperties", "path", "updateConversationViewOnce", "viewOnce", "updateLocalConversationData", "updateMediaShareRestrict", "updateMyMoniker", "updateReadReceipts", "updateUIAfterDestroyingConversation", "updateViewOnce", "updateViewOnceSetting", "verifyUser", "userId", "Companion", "app_debug"})
public final class ChatDetailsActivity extends com.devbeans.io.chat.verifypin.BaseActivity implements com.devbeans.io.chat.network.OnNetworkResponse, com.devbeans.io.chat.callBacks.OnLongMemberCallback, com.devbeans.io.chat.callBacks.OnMembersCallback, com.devbeans.io.chat.callBacks.ExpiryCallback {
    @org.jetbrains.annotations.Nullable
    private com.devbeans.io.chat.databinding.ActivityChatDetailsBinding mBinding;
    private com.devbeans.io.chat.adapters.ImageAdapter mImageAdapter;
    private com.devbeans.io.chat.adapters.GroupMemberAdapter mMembersAdapter;
    private androidx.appcompat.widget.AppCompatButton mCancel;
    private androidx.appcompat.widget.AppCompatButton mAddContact;
    private androidx.appcompat.app.AlertDialog mDialog;
    @org.jetbrains.annotations.Nullable
    private com.devbeans.io.chat.models.Conversation mConversation;
    @org.jetbrains.annotations.Nullable
    private com.devbeans.io.chat.models.Conversation NewConversation;
    private com.devbeans.io.chat.models.Contact mContact;
    private boolean mIsContact = false;
    private boolean isOwner = false;
    private boolean isAdmin = false;
    private boolean mIsOneToOne = false;
    private boolean memberAdded = false;
    private com.devbeans.io.chat.models.Payload payload;
    @org.jetbrains.annotations.Nullable
    private com.google.android.material.textfield.TextInputEditText userIdEdit;
    @org.jetbrains.annotations.Nullable
    private com.google.android.material.textfield.TextInputEditText nameEdit;
    @org.jetbrains.annotations.NotNull
    private java.util.ArrayList<java.lang.String> memberList;
    private final java.lang.String UNBLOCK = "Unblock";
    private final java.lang.String BLOCK = "Block";
    private final java.lang.String DELETE = "Delete";
    private final java.lang.String CLEAR = "Clear";
    private final java.lang.String LEAVE_GROUP = "Leave Group";
    private final java.lang.String DELETE_GROUP = "Delete Group";
    private final java.lang.String CHANGE_OWNER = "Change Owner";
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isCleared = null;
    private androidx.appcompat.app.AlertDialog mDialogViewRemove;
    private androidx.appcompat.app.AlertDialog mCreateDialog;
    private int conversation_pk = 0;
    private boolean addedByQr = false;
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.activities.ChatDetailsActivity.Companion Companion = null;
    @org.jetbrains.annotations.Nullable
    private static com.devbeans.io.chat.activities.ChatDetailsActivity instance;
    private static final java.lang.String TAG = null;
    
    public ChatDetailsActivity() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.databinding.ActivityChatDetailsBinding getMBinding() {
        return null;
    }
    
    public final void setMBinding(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.databinding.ActivityChatDetailsBinding p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.models.Conversation getMConversation() {
        return null;
    }
    
    public final void setMConversation(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.models.Conversation p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.models.Conversation getNewConversation() {
        return null;
    }
    
    public final void setNewConversation(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.models.Conversation p0) {
    }
    
    public final boolean isAdmin() {
        return false;
    }
    
    public final void setAdmin(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.google.android.material.textfield.TextInputEditText getUserIdEdit() {
        return null;
    }
    
    public final void setUserIdEdit(@org.jetbrains.annotations.Nullable
    com.google.android.material.textfield.TextInputEditText p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.google.android.material.textfield.TextInputEditText getNameEdit() {
        return null;
    }
    
    public final void setNameEdit(@org.jetbrains.annotations.Nullable
    com.google.android.material.textfield.TextInputEditText p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<java.lang.String> getMemberList() {
        return null;
    }
    
    public final void setMemberList(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isCleared() {
        return null;
    }
    
    @java.lang.Override
    protected void onDestroy() {
    }
    
    @android.annotation.SuppressLint(value = {"ObsoleteSdkInt"})
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    /**
     * Checks if the current user is an admin or owner of the conversation.
     */
    private final void checkAdmin() {
    }
    
    /**
     * Initializes the views for the conversation screen.
     */
    public final void initViews() {
    }
    
    /**
     * Handles the read receipts views based on the user's settings.
     *
     * @param binding The binding for the chat details activity.
     */
    private final void handleReadReceiptsViews(com.devbeans.io.chat.databinding.ActivityChatDetailsBinding binding) {
    }
    
    /**
     * This method handles the visibility options for a group chat.
     * It sets the visibility of various views based on whether the chat is one-to-one or not.
     * It also sets the text for the group created date if the chat is not one-to-one.
     */
    private final void handleGroupVisibilityOptions() {
    }
    
    private final void clearAndLeaveGroup(com.devbeans.io.chat.databinding.ActivityChatDetailsBinding binding) {
    }
    
    /**
     * Handles the leave group text view based on the conversation type and owner.
     *
     * @param binding The binding for the chat details activity.
     */
    private final void handleLeaveText(com.devbeans.io.chat.databinding.ActivityChatDetailsBinding binding) {
    }
    
    /**
     * Handles the conversation icon based on the conversation type and photo.
     */
    private final void handleConversationIcon() {
    }
    
    /**
     * Loads the conversation icon using Glide.
     *
     * @param icon The icon to load. Can be a String or an Int.
     */
    private final void loadConversationIcon(java.lang.Object icon) {
    }
    
    /**
     * Handles the visibility options for the conversation screen.
     */
    private final void handleVisibilityOptions() {
    }
    
    /**
     * Handles the visibility of the edit option for the conversation details screen.
     *
     * @param binding The binding object for the conversation details screen.
     */
    private final void handleDetailsEditOption(com.devbeans.io.chat.databinding.ActivityChatDetailsBinding binding) {
    }
    
    private final void handleFadeOptions(com.devbeans.io.chat.databinding.ActivityChatDetailsBinding binding) {
    }
    
    private final void handleGroupOptions(com.devbeans.io.chat.databinding.ActivityChatDetailsBinding binding) {
    }
    
    private final kotlin.Unit getChatDetails() {
        return null;
    }
    
    private final void observers() {
    }
    
    /**
     * This method sets up the listeners for the various views in the ChatDetailsActivity
     */
    private final void listeners() {
    }
    
    private final void updateReadReceipts(boolean isChecked) {
    }
    
    private final void updateMediaShareRestrict(boolean isChecked) {
    }
    
    private final void updateConfidential(boolean isChecked) {
    }
    
    private final void updateAutoSaveToVault(boolean isChecked) {
    }
    
    private final void updateViewOnce(boolean isChecked) {
    }
    
    private final void handleTvDescriptionClick() {
    }
    
    private final void handleTvTotalCountClick() {
    }
    
    private final void handTvTotalClick() {
    }
    
    private final void handleAddContactClick() {
    }
    
    private final void handleAddMember() {
    }
    
    private final void handleLeaveGroup() {
    }
    
    private final void handleAddContact() {
    }
    
    private final void updateConversationViewOnce(boolean viewOnce) {
    }
    
    /**
     * Shows a dialog to change the nickname of a contact in the conversation.
     * This function creates and shows an AlertDialog with a custom layout, and sets click listeners for the update and cancel buttons.
     */
    private final void showChangeNickNameDialog() {
    }
    
    private final void verifyUser(java.lang.String userId) {
    }
    
    private final void showCustomDialog(int i) {
    }
    
    /**
     * Shows a dialog to delete the group in the conversation.
     * This function creates and shows an AlertDialog with a custom layout, and sets click listeners for the delete and cancel buttons.
     */
    private final void showDeleteGroupDialog() {
    }
    
    /**
     * Leaves the group in the conversation.
     * This function starts the MembersActivity if `i` is 0, and sends a leave group request to the API if `i` is 1.
     */
    private final void leaveGroup(int i) {
    }
    
    private final void startDisappearingActivity(java.lang.String option) {
    }
    
    private final void startMediaDetailsActivity() {
    }
    
    private final void startDetailsEditActivity() {
    }
    
    private final void openMembersActivity() {
    }
    
    private final void setToolBar(androidx.appcompat.widget.Toolbar toolbar) {
    }
    
    /**
     * Populates the images in the conversation.
     * This function sets the layout manager for the images RecyclerView, sets the images adapter,
     * shows the media, populates the members in the conversation, and sets the text for the group creation time.
     */
    private final void populateRecyclerView() {
    }
    
    /**
     * Populates the members in the conversation.
     * This function sets the layout manager for the members RecyclerView, sets the members adapter,
     * sets the members name, and logs the conversation owner.
     */
    private final void populateMembers() {
    }
    
    /**
     * Handles the change of admin status for the members in the conversation.
     * This function checks the admin status, sets the layout manager for the members RecyclerView,
     * sets the members adapter, sets the members name, and logs the conversation owner.
     */
    public final void adminMemberChange() {
    }
    
    /**
     * Sets the members name in the conversation.
     * This function updates the total count of members in the conversation, sets the member list in the adapter,
     * updates the visibility of the total count and total view, and stores the member IDs in a list.
     */
    private final void setMembersName() {
    }
    
    /**
     * This function is used to display media related to a conversation.
     * It first checks if any media message exists for the conversation.
     * If yes, it fetches all media messages and filters out the downloaded ones
     * which are not view-once and confidential.
     * Finally, it updates the UI based on whether any downloaded media is present.
     */
    private final void showMedia() {
    }
    
    /**
     * This function is used to hide media related UI elements.
     * @param binding: The reference to the view binding
     */
    private final void hideMediaUI(com.devbeans.io.chat.databinding.ActivityChatDetailsBinding binding) {
    }
    
    private final void initDialog() {
    }
    
    @java.lang.Override
    @java.lang.Deprecated
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable
    android.content.Intent data) {
    }
    
    protected final void showLoadingDialog() {
    }
    
    @androidx.annotation.MainThread
    @java.lang.Override
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull
    android.view.MenuItem item) {
        return false;
    }
    
    private final void clearChat() {
    }
    
    /**
     * Adds a new member to the conversation.
     *
     * @param contact the [Contact] to add as a member
     */
    private final void addMember(com.devbeans.io.chat.models.Contact contact) {
    }
    
    private final void addRemoveAdmin(com.devbeans.io.chat.models.ConversationMember member, int i) {
    }
    
    /**
     * This method handles adding members to a group conversation.
     *
     * @param request The AddMembersConversationRequest object containing the request information.
     */
    private final void handleGroupAddApi(com.devbeans.io.chat.network.serializers.requestbody.AddMembersConversationRequest request) {
    }
    
    /**
     * Handles successful API responses based on the request tag.
     *
     * @param call The original call object.
     * @param response The successful response object.
     * @param tag The request code representing the API call made.
     * @throws ParseException if there is an error parsing the response.
     */
    @kotlin.jvm.Throws(exceptionClasses = {java.text.ParseException.class})
    @java.lang.Override
    public void onSuccess(@org.jetbrains.annotations.Nullable
    retrofit2.Call<?> call, @org.jetbrains.annotations.NotNull
    retrofit2.Response<?> response, @org.jetbrains.annotations.NotNull
    java.lang.Object tag) {
    }
    
    /**
     * Helper function to handle API responses with onSuccess and onFailure cases.
     *
     * @param response The response object.
     * @param onSuccessHandler The success handler function.
     */
    private final void handleResponse(retrofit2.Response<?> response, kotlin.jvm.functions.Function1<? super com.devbeans.io.chat.network.serializers.response.NewConversationResponse, kotlin.Unit> onSuccessHandler) {
    }
    
    /**
     * Handles failed API responses by displaying a toast and logging the error message.
     *
     * @param response The failed response object.
     */
    private final void handleFailure(retrofit2.Response<?> response) {
    }
    
    /**
     * Handles the response from the server for updating the media sharing restriction setting of the conversation.
     *
     * @param res The response object containing the updated conversation details.
     */
    private final void handleUpdateMediaRestrictResponse(com.devbeans.io.chat.network.serializers.response.NewConversationResponse res) {
    }
    
    /**
     * Logs the update media sharing restriction response.
     */
    private final void logUpdateMediaRestrictResponse(com.devbeans.io.chat.models.Conversation conversation) {
    }
    
    /**
     * Handles the response from the server for updating the confidentiality setting of the conversation.
     *
     * @param res The response object containing the updated conversation details.
     */
    private final void handleUpdateConfidentialResponse(com.devbeans.io.chat.network.serializers.response.NewConversationResponse res) {
    }
    
    /**
     * Logs the update confidentiality response.
     */
    private final void logUpdateConfidentialResponse(com.devbeans.io.chat.models.Conversation conversation) {
    }
    
    /**
     * Updates the confidentiality setting of the conversation in the local database.
     */
    private final void updateConfidentialSetting(com.devbeans.io.chat.models.Conversation conversation) {
    }
    
    /**
     * Handles the response from the server for destroying the conversation.
     *
     * @param res The response object containing the conversation details.
     */
    private final void handleDestroyConversationResponse(com.devbeans.io.chat.network.serializers.response.NewConversationResponse res) {
    }
    
    /**
     * Updates the local conversation data after the conversation has been destroyed.
     */
    private final void updateLocalConversationData() {
    }
    
    /**
     * Updates the UI and removes the conversation from the chat activity after the conversation has been destroyed.
     */
    private final void updateUIAfterDestroyingConversation() {
    }
    
    /**
     * Handles the response from the server for updating the view once setting of the conversation.
     *
     * @param res The response object containing the updated conversation details.
     */
    private final void handleUpdateViewOnceResponse(com.devbeans.io.chat.network.serializers.response.NewConversationResponse res) {
    }
    
    /**
     * Logs the update view once response.
     */
    private final void logUpdateViewOnceResponse(com.devbeans.io.chat.models.Conversation conversation) {
    }
    
    /**
     * Updates the view once setting of the conversation in the local database.
     */
    private final void updateViewOnceSetting(com.devbeans.io.chat.models.Conversation conversation) {
    }
    
    /**
     * Handles the leave group response from the server, updates the local database, and updates UI accordingly.
     *
     * @param res The response object containing the conversation details after leaving the group.
     */
    private final void handleLeaveGroupResponse(com.devbeans.io.chat.network.serializers.response.NewConversationResponse res) {
    }
    
    /**
     * Logs the leave group response.
     */
    private final void logResponse(com.devbeans.io.chat.models.Conversation conversation) {
    }
    
    /**
     * Determines the appropriate moniker to use for the current user.
     */
    private final java.lang.String getMoniker(com.devbeans.io.chat.models.Conversation conversation) {
        return null;
    }
    
    /**
     * Gets the conversation photo path if it exists.
     */
    private final java.lang.String getConversationPhotoPath(com.devbeans.io.chat.models.Conversation conversation) {
        return null;
    }
    
    /**
     * Updates the local conversation data with the new conversation data from the response.
     */
    private final void updateConversation(com.devbeans.io.chat.models.Conversation conversation, java.lang.String moniker, java.lang.String conversationPhotoPath) {
    }
    
    /**
     * Handles updating the UI after leaving the group.
     */
    private final void handleUIUpdates(com.devbeans.io.chat.models.Conversation conversation, java.lang.String moniker, java.lang.String conversationPhotoPath) {
    }
    
    /**
     * Deletes and resets the channels for the anonymous group conversation.
     */
    private final void deleteAndResetChannels(com.devbeans.io.chat.models.Conversation conversation, java.lang.String moniker) {
    }
    
    /**
     * Handles the response for removing a member from an anonymous conversation.
     *
     * @param res The NewConversationResponse object, which may be null.
     */
    private final void handleRemoveMemberAnonymousResponse(com.devbeans.io.chat.network.serializers.response.NewConversationResponse res) {
    }
    
    /**
     * Updates the user's moniker based on the conversation type.
     *
     * @param moniker The moniker to be updated in the case of an anonymous conversation.
     */
    private final void updateMyMoniker(java.lang.String moniker) {
    }
    
    /**
     * Handles the response for removing a member from a group conversation.
     *
     * @param res The NewConversationResponse object, which may be null.
     */
    private final void handleRemoveMemberGroupResponse(com.devbeans.io.chat.network.serializers.response.NewConversationResponse res) {
    }
    
    /**
     * Logs the details of a removed member in a group conversation.
     *
     * @param conversation The conversation object containing the removed member's details.
     */
    private final void logRemoveMemberDetails(com.devbeans.io.chat.models.Conversation conversation) {
    }
    
    /**
     * Handles the response for removing admin role from a member in an anonymous group conversation.
     *
     * @param res The NewConversationResponse object, which may be null.
     */
    private final void handleAdminRemovedAnonymousResponse(com.devbeans.io.chat.network.serializers.response.NewConversationResponse res) {
    }
    
    /**
     * Handles the response for removing admin role from a member in a group conversation.
     *
     * @param res The NewConversationResponse object, which may be null.
     */
    private final void handleAdminRemovedGroupResponse(com.devbeans.io.chat.network.serializers.response.NewConversationResponse res) {
    }
    
    /**
     * Handles the response for assigning admin role to a member in an anonymous group conversation.
     *
     * @param res The NewConversationResponse object, which may be null.
     */
    private final void handleAdminAssignedAnonymousResponse(com.devbeans.io.chat.network.serializers.response.NewConversationResponse res) {
    }
    
    /**
     * Handles the response for assigning admin role to a member in a group conversation.
     *
     * @param res The NewConversationResponse object, which may be null.
     */
    private final void handleAdminAssignedGroupResponse(com.devbeans.io.chat.network.serializers.response.NewConversationResponse res) {
    }
    
    /**
     * Handles the response for adding a member to an anonymous conversation.
     *
     * @param res The NewConversationResponse object, which may be null.
     */
    private final void handleMemberAddedAnonymousResponse(com.devbeans.io.chat.network.serializers.response.NewConversationResponse res) {
    }
    
    /**
     * Handles the response for adding a member to a group conversation.
     *
     * @param res The NewConversationResponse object, which may be null.
     */
    private final void handleMemberAddedGroupResponse(com.devbeans.io.chat.network.serializers.response.NewConversationResponse res) {
    }
    
    /**
     * Handles the response for adding a member to a conversation.
     *
     * @param res The NewConversationResponse object, which may be null.
     */
    private final void handleMemberAddedResponse(com.devbeans.io.chat.network.serializers.response.NewConversationResponse res) {
    }
    
    private final void dismissDialogs() {
    }
    
    private final void logConversationDetails(com.devbeans.io.chat.models.Conversation conversation) {
    }
    
    private final java.lang.String getConversationPhotoPath() {
        return null;
    }
    
    private final void updateConversationProperties(com.devbeans.io.chat.models.Conversation conversation, java.lang.String path) {
    }
    
    private final void updateMyMoniker() {
    }
    
    private final void updateChatActivityInstance() {
    }
    
    private final void createSymmetricHandshakeIfNeeded() {
    }
    
    private final void handleVerifyUserResponse(retrofit2.Response<?> response) {
    }
    
    private final void handleUpdatingContacts(boolean hasContact, com.devbeans.io.chat.models.Contact existedContact, com.devbeans.io.chat.models.Contact contact) {
    }
    
    @java.lang.Override
    public void onFailure(@org.jetbrains.annotations.Nullable
    retrofit2.Call<?> call, @org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.network.serializers.response.BaseResponse response, @org.jetbrains.annotations.NotNull
    java.lang.Object tag) {
    }
    
    @java.lang.Override
    public void onLongMemberCallback(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.ConversationMember member, @org.jetbrains.annotations.NotNull
    java.lang.String name) {
    }
    
    @java.lang.Override
    protected void onResume() {
    }
    
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    private final void showViewRemoveDialog(com.devbeans.io.chat.models.ConversationMember member, java.lang.String name) {
    }
    
    private final void removeMember(com.devbeans.io.chat.models.ConversationMember id) {
    }
    
    @java.lang.Override
    public void onMemberCallback(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.ConversationMember id, @org.jetbrains.annotations.NotNull
    java.lang.String name) {
    }
    
    public final void startObserver(@org.jetbrains.annotations.Nullable
    java.io.File img_file) {
    }
    
    @java.lang.Override
    public void notifyExpiry() {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0014\u001a\u0004\u0018\u00010\tR\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0015"}, d2 = {"Lcom/devbeans/io/chat/activities/ChatDetailsActivity$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "instance", "Lcom/devbeans/io/chat/activities/ChatDetailsActivity;", "getInstance", "()Lcom/devbeans/io/chat/activities/ChatDetailsActivity;", "setInstance", "(Lcom/devbeans/io/chat/activities/ChatDetailsActivity;)V", "createTransitionBundle", "Landroid/os/Bundle;", "context", "Landroid/content/Context;", "avatar", "Landroid/view/View;", "getDetailsInstance", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable
        public final com.devbeans.io.chat.activities.ChatDetailsActivity getInstance() {
            return null;
        }
        
        public final void setInstance(@org.jetbrains.annotations.Nullable
        com.devbeans.io.chat.activities.ChatDetailsActivity p0) {
        }
        
        public final java.lang.String getTAG() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final com.devbeans.io.chat.activities.ChatDetailsActivity getDetailsInstance() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final android.os.Bundle createTransitionBundle(@org.jetbrains.annotations.Nullable
        android.content.Context context, @org.jetbrains.annotations.NotNull
        android.view.View avatar) {
            return null;
        }
    }
}