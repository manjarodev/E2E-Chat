package com.devbeans.io.chat.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u00d2\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0016\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0005\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 \u00fa\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\b\u0012\u0004\u0012\u00020\u00060\u00052\u00020\u00072\u00020\b2\b\u0012\u0004\u0012\u00020\u00060\t2\u00020\n2\u00020\u000b2\u00020\f2\u00020\r:\u0002\u00fa\u0002B\u0005\u00a2\u0006\u0002\u0010\u000eJ)\u0010\u00a4\u0001\u001a\u00030\u0087\u00012\u0007\u0010\u00a5\u0001\u001a\u00020\u00102\n\u0010\u00a6\u0001\u001a\u0005\u0018\u00010\u00a7\u00012\n\u0010\u00a8\u0001\u001a\u0005\u0018\u00010\u0085\u0001J\b\u0010\u00a9\u0001\u001a\u00030\u0087\u0001J\u0011\u0010\u00aa\u0001\u001a\u00030\u0087\u00012\u0007\u0010\u00ab\u0001\u001a\u00020\u0010J\n\u0010\u00ac\u0001\u001a\u00030\u0087\u0001H\u0002J\u0016\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u00172\t\u0010\u00ae\u0001\u001a\u0004\u0018\u00010\u0010H\u0002J\u001c\u0010\u00af\u0001\u001a\u00020%2\u0007\u0010\u00b0\u0001\u001a\u00020%2\b\u0010\u00b1\u0001\u001a\u00030\u0085\u0001H\u0002J\u0013\u0010\u00b2\u0001\u001a\u00020%2\b\u0010\u00b1\u0001\u001a\u00030\u0085\u0001H\u0002J\t\u0010\u00b3\u0001\u001a\u00020%H\u0002J\u0012\u0010\u00b4\u0001\u001a\u00020%2\u0007\u0010\u00b5\u0001\u001a\u00020\u0006H\u0002J\b\u0010\u00b6\u0001\u001a\u00030\u0087\u0001J\n\u0010\u00b7\u0001\u001a\u00030\u0087\u0001H\u0002J\b\u0010\u00b8\u0001\u001a\u00030\u0087\u0001J>\u0010\u00b9\u0001\u001a\u00030\u0087\u00012\u0007\u0010\u0098\u0001\u001a\u00020\u00102\u0006\u0010|\u001a\u00020\u00102\u0007\u0010\u00ba\u0001\u001a\u00020\u00102\u0007\u0010\u00bb\u0001\u001a\u00020\u00102\u0007\u0010\u00bc\u0001\u001a\u00020\u00102\b\u0010\u00bd\u0001\u001a\u00030\u00be\u0001J#\u0010\u00b9\u0001\u001a\u00030\u0087\u00012\u0019\u0010\u00bf\u0001\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0007\u0012\u0005\u0018\u00010\u00c1\u00010\u00c0\u0001J>\u0010\u00c2\u0001\u001a\u00030\u0087\u00012\u0007\u0010\u0098\u0001\u001a\u00020\u00102\u0006\u0010|\u001a\u00020\u00102\u0007\u0010\u00ba\u0001\u001a\u00020\u00102\u0007\u0010\u00bb\u0001\u001a\u00020\u00102\u0007\u0010\u00bc\u0001\u001a\u00020\u00102\b\u0010\u00bd\u0001\u001a\u00030\u00be\u0001J#\u0010\u00c2\u0001\u001a\u00030\u0087\u00012\u0019\u0010\u00bf\u0001\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0007\u0012\u0005\u0018\u00010\u00c1\u00010\u00c0\u0001J\u0011\u0010\u00c3\u0001\u001a\u00030\u0087\u00012\u0007\u0010\u00c4\u0001\u001a\u00020\u0010J\u0013\u0010\u00c5\u0001\u001a\u00030\u0087\u00012\t\u0010\u00c4\u0001\u001a\u0004\u0018\u00010\u0010J\u0013\u0010\u00c6\u0001\u001a\u00030\u0087\u00012\u0007\u0010\u00c7\u0001\u001a\u00020\u0010H\u0002J\u0014\u0010\u00c8\u0001\u001a\u00030\u0087\u00012\b\u0010\u00b1\u0001\u001a\u00030\u0085\u0001H\u0002J\u0015\u0010\u00c9\u0001\u001a\u00020%2\n\u0010\u00ca\u0001\u001a\u0005\u0018\u00010\u00cb\u0001H\u0016J\u0014\u0010\u00cc\u0001\u001a\u00030\u0087\u00012\b\u0010\u00cd\u0001\u001a\u00030\u00ce\u0001H\u0002J\u0014\u0010\u00cf\u0001\u001a\u00030\u0087\u00012\b\u0010\u00cd\u0001\u001a\u00030\u00ce\u0001H\u0002J\u0011\u0010\u00d0\u0001\u001a\n\u0012\u0005\u0012\u00030\u00d2\u00010\u00d1\u0001H\u0002J\t\u0010\u00d3\u0001\u001a\u00020%H\u0002J\u0014\u0010\u00d4\u0001\u001a\u00030\u0087\u00012\b\u0010\u00d5\u0001\u001a\u00030\u00d6\u0001H\u0002J\n\u0010\u00d7\u0001\u001a\u00030\u0087\u0001H\u0002J\n\u0010\u00d8\u0001\u001a\u00030\u0087\u0001H\u0002J\n\u0010\u00d9\u0001\u001a\u00030\u0087\u0001H\u0002J\n\u0010\u00da\u0001\u001a\u00030\u0087\u0001H\u0002J\n\u0010\u00db\u0001\u001a\u00030\u0087\u0001H\u0002J\n\u0010\u00dc\u0001\u001a\u00030\u0087\u0001H\u0002J\u0014\u0010\u00dd\u0001\u001a\u00030\u0087\u00012\b\u0010\u00de\u0001\u001a\u00030\u00a7\u0001H\u0002J\n\u0010\u00df\u0001\u001a\u00030\u0087\u0001H\u0002J\u001a\u0010\u00e0\u0001\u001a\u00030\u0087\u00012\u000e\u0010\u00e1\u0001\u001a\t\u0012\u0004\u0012\u00020}0\u00d1\u0001H\u0002J\u001a\u0010\u00e2\u0001\u001a\u00030\u0087\u00012\u000e\u0010\u00e1\u0001\u001a\t\u0012\u0004\u0012\u00020}0\u00d1\u0001H\u0002J\u0014\u0010\u00e3\u0001\u001a\u00030\u0087\u00012\b\u0010\u00e4\u0001\u001a\u00030\u00e5\u0001H\u0002J\u0013\u0010\u00e6\u0001\u001a\u00030\u0087\u00012\u0007\u0010\u00e7\u0001\u001a\u00020\u007fH\u0002J\b\u0010\u00e8\u0001\u001a\u00030\u0087\u0001J\u0013\u0010\u00e9\u0001\u001a\u00030\u0087\u00012\u0007\u0010\u00ea\u0001\u001a\u00020\u0017H\u0002J\u0014\u0010\u00eb\u0001\u001a\u00030\u0087\u00012\b\u0010\u00de\u0001\u001a\u00030\u00a7\u0001H\u0002J\n\u0010\u00ec\u0001\u001a\u00030\u0087\u0001H\u0002J\n\u0010\u00ed\u0001\u001a\u00030\u0087\u0001H\u0002J\n\u0010\u00ee\u0001\u001a\u00030\u0087\u0001H\u0003J\n\u0010\u00ef\u0001\u001a\u00030\u0087\u0001H\u0002J-\u0010\u00f0\u0001\u001a\u00030\u0087\u00012\u000f\u0010\u00f1\u0001\u001a\n\u0012\u0005\u0012\u00030\u0085\u00010\u00d1\u00012\u0007\u0010\u00f2\u0001\u001a\u00020%2\u0007\u0010\u00f3\u0001\u001a\u00020%H\u0002J\u0013\u0010\u00f4\u0001\u001a\u00030\u0087\u00012\u0007\u0010\u00b5\u0001\u001a\u00020\u0006H\u0002J\b\u0010\u00f5\u0001\u001a\u00030\u0087\u0001J\u001e\u0010\u00f6\u0001\u001a\u00030\u0087\u00012\b\u0010\u00de\u0001\u001a\u00030\u00a7\u00012\b\u0010\u00b1\u0001\u001a\u00030\u0085\u0001H\u0002J\n\u0010\u00f7\u0001\u001a\u00030\u0087\u0001H\u0002J\n\u0010\u00f8\u0001\u001a\u00030\u0087\u0001H\u0002J/\u0010\u00f9\u0001\u001a\u00030\u0087\u00012\u0007\u0010\u00ea\u0001\u001a\u00020\u00172\u0007\u0010\u00fa\u0001\u001a\u00020%2\u0007\u0010\u00fb\u0001\u001a\u00020\u00172\b\u0010\u00d5\u0001\u001a\u00030\u00d6\u0001H\u0002J\n\u0010\u00fc\u0001\u001a\u00030\u0087\u0001H\u0002J\u001d\u0010\u00fd\u0001\u001a\u00030\u0087\u00012\u0006\u0010|\u001a\u00020}2\t\u0010\u00ea\u0001\u001a\u0004\u0018\u00010\u0017H\u0002J\u001d\u0010\u00fe\u0001\u001a\u00030\u0087\u00012\u0006\u0010|\u001a\u00020}2\t\u0010\u00ea\u0001\u001a\u0004\u0018\u00010\u0017H\u0002J\u001d\u0010\u00ff\u0001\u001a\u00030\u0087\u00012\u0006\u0010|\u001a\u00020}2\t\u0010\u00ea\u0001\u001a\u0004\u0018\u00010\u0017H\u0002J\u001d\u0010\u0080\u0002\u001a\u00030\u0087\u00012\u0006\u0010|\u001a\u00020}2\t\u0010\u00ea\u0001\u001a\u0004\u0018\u00010\u0017H\u0002J\u0013\u0010\u0081\u0002\u001a\u00030\u0087\u00012\u0007\u0010\u00b5\u0001\u001a\u00020\u0006H\u0002J\u001c\u0010\u0082\u0002\u001a\u00020%2\u0007\u0010\u00b5\u0001\u001a\u00020\u00062\b\u0010\u0098\u0001\u001a\u00030\u0083\u0002H\u0016J\b\u0010\u0084\u0002\u001a\u00030\u0087\u0001J\b\u0010\u0085\u0002\u001a\u00030\u0087\u0001J\n\u0010\u0086\u0002\u001a\u00030\u0087\u0001H\u0002J\u0013\u0010\u0087\u0002\u001a\u00030\u0087\u00012\u0007\u0010\u0088\u0002\u001a\u00020\u0019H\u0002J\n\u0010\u0089\u0002\u001a\u00030\u0087\u0001H\u0003J\u0012\u0010\u008a\u0002\u001a\u00030\u0087\u00012\b\u0010\u00b1\u0001\u001a\u00030\u0085\u0001J\b\u0010\u008b\u0002\u001a\u00030\u0087\u0001J\u0014\u0010\u008c\u0002\u001a\u00030\u0087\u00012\n\u0010\u00b1\u0001\u001a\u0005\u0018\u00010\u0085\u0001J\t\u0010\u008d\u0002\u001a\u00020\u0019H\u0002J\t\u0010\u008e\u0002\u001a\u00020\u0019H\u0002J\t\u0010\u008f\u0002\u001a\u00020\u0019H\u0002J\t\u0010\u0090\u0002\u001a\u00020\u0019H\u0002J\t\u0010\u0091\u0002\u001a\u00020\u0019H\u0002J\t\u0010\u0092\u0002\u001a\u00020\u0019H\u0002J\t\u0010\u0093\u0002\u001a\u00020\u0019H\u0002J\u0015\u0010\u0094\u0002\u001a\u0004\u0018\u00010\u00062\b\u0010\u00b1\u0001\u001a\u00030\u0085\u0001H\u0002J\n\u0010\u0095\u0002\u001a\u00030\u0087\u0001H\u0016J\n\u0010\u0096\u0002\u001a\u00030\u0087\u0001H\u0002J\u0014\u0010\u0097\u0002\u001a\u00030\u0087\u00012\b\u0010\u0098\u0002\u001a\u00030\u0099\u0002H\u0016J(\u0010\u009a\u0002\u001a\u00030\u0087\u00012\u0007\u0010\u009b\u0002\u001a\u00020\u00192\u0007\u0010\u009c\u0002\u001a\u00020\u00192\n\u0010\u009d\u0002\u001a\u0005\u0018\u00010\u009e\u0002H\u0015J\n\u0010\u009f\u0002\u001a\u00030\u0087\u0001H\u0016J\n\u0010\u00a0\u0002\u001a\u00030\u0087\u0001H\u0016J\u001d\u0010\u00a1\u0002\u001a\u00030\u0087\u00012\b\u0010\u00a2\u0002\u001a\u00030\u00a3\u00022\u0007\u0010\u0088\u0002\u001a\u00020\u0019H\u0016J$\u0010\u00a4\u0002\u001a\u00030\u0087\u00012\u0007\u0010\u00a5\u0002\u001a\u00020\u00062\u0007\u0010\u00a6\u0002\u001a\u00020\u00192\b\u0010\u00a7\u0002\u001a\u00030\u008f\u0001J\u0016\u0010\u00a8\u0002\u001a\u00030\u0087\u00012\n\u0010\u00a9\u0002\u001a\u0005\u0018\u00010\u00aa\u0002H\u0015J\n\u0010\u00ab\u0002\u001a\u00030\u0087\u0001H\u0014J.\u0010\u00ac\u0002\u001a\u00030\u0087\u00012\u000e\u0010\u00ad\u0002\u001a\t\u0012\u0002\b\u0003\u0018\u00010\u00ae\u00022\b\u0010\u00af\u0002\u001a\u00030\u00b0\u00022\b\u0010\u00b1\u0002\u001a\u00030\u00b2\u0002H\u0016J\n\u0010\u00b3\u0002\u001a\u00030\u0087\u0001H\u0016J\u001c\u0010\u00b4\u0002\u001a\u00030\u0087\u00012\u0007\u0010\u00b5\u0002\u001a\u00020\u00192\u0007\u0010\u00b6\u0002\u001a\u00020\u0019H\u0016J$\u0010\u00b7\u0002\u001a\u00030\u0087\u00012\u0007\u0010\u00a5\u0002\u001a\u00020\u00062\u0007\u0010\u00a6\u0002\u001a\u00020\u00192\b\u0010\u00b8\u0002\u001a\u00030\u00ce\u0001J\u001d\u0010\u00b9\u0002\u001a\u00030\u0087\u00012\b\u0010\u00b8\u0002\u001a\u00030\u00ce\u00012\u0007\u0010\u00b5\u0001\u001a\u00020\u0006H\u0016J\u0013\u0010\u00ba\u0002\u001a\u00020%2\b\u0010\u00bb\u0002\u001a\u00030\u00bc\u0002H\u0017J\n\u0010\u00bd\u0002\u001a\u00030\u0087\u0001H\u0016J\u0013\u0010\u00be\u0002\u001a\u00030\u00be\u00012\u0007\u0010\u00b1\u0002\u001a\u00020\u0010H\u0002J\n\u0010\u00bf\u0002\u001a\u00030\u0087\u0001H\u0016J\u001e\u0010\u00c0\u0002\u001a\u00030\u0087\u00012\b\u0010\u00c1\u0002\u001a\u00030\u00c2\u00022\b\u0010\u00c3\u0002\u001a\u00030\u00c2\u0002H\u0016J\n\u0010\u00c4\u0002\u001a\u00030\u0087\u0001H\u0016J\n\u0010\u00c5\u0002\u001a\u00030\u0087\u0001H\u0016J\n\u0010\u00c6\u0002\u001a\u00030\u0087\u0001H\u0016J5\u0010\u00c7\u0002\u001a\u00030\u0087\u00012\u0007\u0010\u009b\u0002\u001a\u00020\u00192\u0010\u0010\u00c8\u0002\u001a\u000b\u0012\u0006\b\u0001\u0012\u00020\u00100\u00c9\u00022\b\u0010\u00ca\u0002\u001a\u00030\u00cb\u0002H\u0016\u00a2\u0006\u0003\u0010\u00cc\u0002J\n\u0010\u00cd\u0002\u001a\u00030\u0087\u0001H\u0015J\n\u0010\u00ce\u0002\u001a\u00030\u0087\u0001H\u0014J\n\u0010\u00cf\u0002\u001a\u00030\u0087\u0001H\u0014J\u0013\u0010\u00d0\u0002\u001a\u00020%2\b\u0010\u00de\u0001\u001a\u00030\u00a7\u0001H\u0016J2\u0010\u00d1\u0002\u001a\u00030\u0087\u00012\u000e\u0010\u00ad\u0002\u001a\t\u0012\u0002\b\u0003\u0018\u00010\u00ae\u00022\f\u0010\u00af\u0002\u001a\u0007\u0012\u0002\b\u00030\u00d2\u00022\b\u0010\u00b1\u0002\u001a\u00030\u00b2\u0002H\u0017J\u0011\u0010\u00d3\u0002\u001a\u00030\u0087\u00012\u0007\u0010\u00b5\u0001\u001a\u00020\u0006J\n\u0010\u00d4\u0002\u001a\u00030\u0087\u0001H\u0002J\u0012\u0010\u00d5\u0002\u001a\u00030\u0087\u00012\b\u0010\u00d6\u0002\u001a\u00030\u0085\u0001J\u0011\u0010\u00d5\u0002\u001a\u00030\u0087\u00012\u0007\u0010\u00d7\u0002\u001a\u00020\u0010J\n\u0010\u00d8\u0002\u001a\u00030\u0087\u0001H\u0003J\n\u0010\u00d9\u0002\u001a\u00030\u0087\u0001H\u0002J\u0014\u0010\u00da\u0002\u001a\u00030\u0087\u00012\b\u0010\u00db\u0002\u001a\u00030\u0085\u0001H\u0002J2\u0010\u00dc\u0002\u001a\u00030\u0087\u00012\u0007\u0010\u00f2\u0001\u001a\u00020%2\u0007\u0010\u00f3\u0001\u001a\u00020%2\n\u0010\u00db\u0002\u001a\u0005\u0018\u00010\u0085\u00012\b\u0010\u00b1\u0001\u001a\u00030\u0085\u0001H\u0002J2\u0010\u00dd\u0002\u001a\u00030\u0087\u00012\u0007\u0010\u00f2\u0001\u001a\u00020%2\u0007\u0010\u00f3\u0001\u001a\u00020%2\n\u0010\u00db\u0002\u001a\u0005\u0018\u00010\u0085\u00012\b\u0010\u00b1\u0001\u001a\u00030\u0085\u0001H\u0002J\u0013\u0010\u00de\u0002\u001a\u00030\u0087\u00012\u0007\u0010\u00df\u0002\u001a\u00020XH\u0003J\n\u0010\u00e0\u0002\u001a\u00030\u0087\u0001H\u0002J\n\u0010\u00e1\u0002\u001a\u00030\u0087\u0001H\u0002J\u0012\u0010\u00e2\u0002\u001a\u00030\u0087\u00012\b\u0010\'\u001a\u0004\u0018\u00010(J\b\u0010\u00e3\u0002\u001a\u00030\u0087\u0001J\n\u0010\u00e4\u0002\u001a\u00030\u0087\u0001H\u0002J\n\u0010\u00e5\u0002\u001a\u00030\u0087\u0001H\u0002J\u0014\u0010\u00e6\u0002\u001a\u00030\u0087\u00012\b\u0010\u00e7\u0002\u001a\u00030\u00e8\u0002H\u0002J\u0013\u0010\u00e9\u0002\u001a\u00030\u0087\u00012\u0007\u0010\u00df\u0002\u001a\u00020XH\u0002J\n\u0010\u00ea\u0002\u001a\u00030\u0087\u0001H\u0002J\n\u0010\u00eb\u0002\u001a\u00030\u0087\u0001H\u0002J\u0013\u0010\u00ec\u0002\u001a\u00030\u0087\u00012\u0007\u0010\u0088\u0002\u001a\u00020\u0019H\u0002J\n\u0010\u00ed\u0002\u001a\u00030\u0087\u0001H\u0002J\n\u0010\u00ee\u0002\u001a\u00030\u0087\u0001H\u0002J\n\u0010\u00ef\u0002\u001a\u00030\u0087\u0001H\u0002J\n\u0010\u00f0\u0002\u001a\u00030\u0087\u0001H\u0016J\n\u0010\u00f1\u0002\u001a\u00030\u0087\u0001H\u0002J\u0012\u0010\u00f2\u0002\u001a\u00030\u0087\u00012\b\u0010G\u001a\u0004\u0018\u000100J\n\u0010\u00f3\u0002\u001a\u00030\u0087\u0001H\u0002J\n\u0010\u00f4\u0002\u001a\u00030\u0087\u0001H\u0002J\n\u0010\u00f5\u0002\u001a\u00030\u0087\u0001H\u0002J\n\u0010\u00f6\u0002\u001a\u00030\u0087\u0001H\u0002J\u0014\u0010\u00f7\u0002\u001a\u00030\u0087\u00012\n\u0010\u00b1\u0001\u001a\u0005\u0018\u00010\u0085\u0001J\n\u0010\u00f8\u0002\u001a\u00030\u0087\u0001H\u0003J\n\u0010\u00f9\u0002\u001a\u00030\u0087\u0001H\u0003R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0010X\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020%X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020%X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\'\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010*\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u0010/\u001a\u0004\u0018\u000100X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001c\u00105\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u0010!\"\u0004\b7\u0010#R\"\u00108\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u000109X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001c\u0010>\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010!\"\u0004\b@\u0010#R\u001c\u0010A\u001a\u0004\u0018\u00010BX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u0010\u0010G\u001a\u0004\u0018\u000100X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010H\u001a\u00020%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001a\u0010L\u001a\u00020%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bL\u0010I\"\u0004\bM\u0010KR\u001a\u0010N\u001a\u00020%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bN\u0010I\"\u0004\bO\u0010KR\u000e\u0010P\u001a\u00020%X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020RX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010S\u001a\u0004\u0018\u00010TX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010U\u001a\u0004\u0018\u00010VX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010W\u001a\u0004\u0018\u00010XX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u000e\u0010]\u001a\u00020^X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010_\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010`\u001a\u0004\u0018\u00010aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010b\u001a\u0004\u0018\u000100X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010c\u001a\u00020%X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010d\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\be\u0010!\"\u0004\bf\u0010#R\u0010\u0010g\u001a\u0004\u0018\u00010hX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020jX\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010k\u001a\u0004\u0018\u00010lX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\u0010\u0010q\u001a\u0004\u0018\u00010rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010s\u001a\u0004\u0018\u00010tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR\u001c\u0010y\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bz\u0010!\"\u0004\b{\u0010#R\u0010\u0010|\u001a\u0004\u0018\u00010}X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010~\u001a\u0004\u0018\u00010\u007fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R$\u0010\u0080\u0001\u001a\t\u0012\u0005\u0012\u00030\u0081\u000109X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0082\u0001\u0010;\"\u0005\b\u0083\u0001\u0010=R\u0012\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0085\u0001X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0086\u0001\u001a\u00030\u0087\u00018BX\u0082\u0004\u00a2\u0006\b\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001R\u0010\u0010\u008a\u0001\u001a\u00030\u008b\u0001X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u008c\u0001\u001a\u00030\u008d\u0001X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u008e\u0001\u001a\u00030\u008f\u0001X\u0082.\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0090\u0001\u001a\u00030\u0087\u00018CX\u0082\u0004\u00a2\u0006\b\u001a\u0006\b\u0091\u0001\u0010\u0089\u0001R\u000f\u0010\u0092\u0001\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001f\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0094\u0001\u0010!\"\u0005\b\u0095\u0001\u0010#R\u0010\u0010\u0096\u0001\u001a\u00030\u0097\u0001X\u0082.\u00a2\u0006\u0002\n\u0000R\u001f\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0099\u0001\u0010!\"\u0005\b\u009a\u0001\u0010#R\"\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009c\u0001X\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001\"\u0006\b\u009f\u0001\u0010\u00a0\u0001R\u000f\u0010\u00a1\u0001\u001a\u00020%X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u00a2\u0001\u001a\u00030\u00a3\u0001X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u00fb\u0002"}, d2 = {"Lcom/devbeans/io/chat/activities/ChatActivity;", "Lcom/devbeans/io/chat/verifypin/BaseActivity;", "Lcom/stfalcon/chatkit/messages/MessagesListAdapter$OnLoadMoreListener;", "Lcom/stfalcon/chatkit/messages/MessageInput$InputListener;", "Lcom/stfalcon/chatkit/messages/MessageInput$AttachmentsListener;", "Lcom/stfalcon/chatkit/messages/MessageHolders$ContentChecker;", "Lcom/devbeans/io/chat/models/Messages;", "Landroid/content/DialogInterface$OnClickListener;", "Lcom/devbeans/io/chat/network/OnNetworkResponse;", "Lcom/stfalcon/chatkit/messages/MessagesListAdapter$OnMessageViewClickListener;", "Lcom/devbeans/io/chat/utils/views/ConversationReactionOverlay$OnActionSelectedListener;", "Lcom/devbeans/io/chat/utils/views/ConversationReactionOverlay$OnHideListener;", "Lcom/devbeans/io/chat/utils/views/MicrophoneRecorderView$Listener;", "Lcom/devbeans/io/chat/callBacks/ExpiryCallback;", "()V", "BLOCK", "", "CHANGE_OWNER", "CLEAR", "DELETE", "DELETE_GROUP", "LEAVE_GROUP", "NewContact", "Lcom/devbeans/io/chat/models/Contact;", "REQUEST_CODE", "", "UNBLOCK", "activeContextMenu", "Lcom/devbeans/io/chat/utils/components/menu/ChatContextMenu;", "audioRecorder", "Lcom/devbeans/io/chat/utils/AudioRecorder;", "avRatchetKeyMaterial", "getAvRatchetKeyMaterial", "()Ljava/lang/String;", "setAvRatchetKeyMaterial", "(Ljava/lang/String;)V", "canSendAudio", "", "contactAdded", "conversation", "Lcom/devbeans/io/chat/models/Conversation;", "conversation_pk", "editingMessage", "getEditingMessage", "()Lcom/devbeans/io/chat/models/Messages;", "setEditingMessage", "(Lcom/devbeans/io/chat/models/Messages;)V", "file", "Ljava/io/File;", "getFile", "()Ljava/io/File;", "setFile", "(Ljava/io/File;)V", "filePath", "getFilePath", "setFilePath", "groupMembers", "", "getGroupMembers", "()Ljava/util/List;", "setGroupMembers", "(Ljava/util/List;)V", "groupName", "getGroupName", "setGroupName", "imageLoader", "Lcom/stfalcon/chatkit/commons/ImageLoader;", "getImageLoader", "()Lcom/stfalcon/chatkit/commons/ImageLoader;", "setImageLoader", "(Lcom/stfalcon/chatkit/commons/ImageLoader;)V", "img_file", "isBlocked", "()Z", "setBlocked", "(Z)V", "isForwarded", "setForwarded", "isFromForwardUpload", "setFromForwardUpload", "isToggle", "itemTouchHelper", "Landroidx/recyclerview/widget/ItemTouchHelper;", "lastLoadedDate", "Ljava/util/Date;", "loader", "Lcom/devbeans/io/chat/utils/Loading;", "mBinding", "Lcom/devbeans/io/chat/databinding/ActivityChatBinding;", "getMBinding", "()Lcom/devbeans/io/chat/databinding/ActivityChatBinding;", "setMBinding", "(Lcom/devbeans/io/chat/databinding/ActivityChatBinding;)V", "mCommandReceiver", "Landroid/content/BroadcastReceiver;", "mContact", "mCreateDialog", "Landroidx/appcompat/app/AlertDialog;", "mFile", "mIsContact", "mName", "getMName", "setMName", "mPop", "Landroid/widget/PopupWindow;", "mPopup", "Lcom/vanniktech/emoji/EmojiPopup;", "mRoom", "Lcom/devbeans/io/chat/models/ChatRoom;", "getMRoom", "()Lcom/devbeans/io/chat/models/ChatRoom;", "setMRoom", "(Lcom/devbeans/io/chat/models/ChatRoom;)V", "mUser", "Lcom/devbeans/io/chat/models/User;", "mViewModel", "Lcom/devbeans/io/chat/viewmodels/ChatViewModel;", "getMViewModel", "()Lcom/devbeans/io/chat/viewmodels/ChatViewModel;", "setMViewModel", "(Lcom/devbeans/io/chat/viewmodels/ChatViewModel;)V", "mediaType", "getMediaType", "setMediaType", "member", "Lcom/devbeans/io/chat/models/ConversationMember;", "menuBinding", "Lcom/devbeans/io/chat/databinding/CustomMenuBinding;", "messageList", "Lcom/devbeans/io/chat/models/Message;", "getMessageList", "setMessageList", "payloadToForward", "Lcom/devbeans/io/chat/models/Payload;", "profileData", "", "getProfileData", "()Lkotlin/Unit;", "reactionDelegate", "Lcom/devbeans/io/chat/utils/views/ConversationReactionDelegate;", "recordTime", "Lcom/devbeans/io/chat/utils/RecordTime;", "recordingContainer", "Landroidx/constraintlayout/widget/ConstraintLayout;", "roomData", "getRoomData", "selected_time", "senderId", "getSenderId", "setSenderId", "slideToCancel", "Lcom/devbeans/io/chat/utils/SlideToCancel;", "type", "getType", "setType", "uploadingSecreteFingerprint", "", "getUploadingSecreteFingerprint", "()[B", "setUploadingSecreteFingerprint", "([B)V", "viewOnce", "voiceRecorderWakeLock", "Lcom/devbeans/io/chat/utils/VoiceRecorderWakeLock;", "CreateMainSymmeticHandshake", "conversation_id", "sentMessage", "", "messagePayload", "addedInConversation", "autoSaveToVault", "path", "blockUser", "checkContactNull", "memberID", "checkIsContact", "oneToOne", "payload", "checkPayloadWithConversation", "checkPermission", "checkViewClickPayload", "message", "clearChat", "clearConversationChat", "conversationRemoved", "createAnonymousNewConversation", "userChatId", "description", "name", "selectedTime", "", "map", "", "Lokhttp3/RequestBody;", "createNewConversation", "deleteById", "id", "deleteExpiryMessage", "deleteMessage", "deletionType", "deleteMessageFile", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "fadeIn", "v", "Landroid/view/View;", "fadeOut", "getMenuItems", "", "Lcom/devbeans/io/chat/utils/views/ActionItem;", "getReadReceipt", "handleAddContactDialogButton", "mCreateDialogBinding", "Lcom/devbeans/io/chat/databinding/CustomDailogAddContactBinding;", "handleAddContactOption", "handleAttachmentPopup", "handleBlockDialog", "handleBlockOption", "handleCopyClick", "handleDisappearOption", "handleEditPayload", "input", "handleEnterToSent", "handleGroupMember", "conMembers", "handleGroupMemberAnon", "handleLeaveGroup", "dialogBinding", "Lcom/devbeans/io/chat/databinding/CustomBlockDailogBinding;", "handleMenuVisibility", "customMenuBinding", "handleNewConSendConfidentialMessage", "handleNewContactAdding", "contact", "handleNormalPayload", "handleOnStartTyping", "handleOnStopTyping", "handlePastClick", "handleReaction", "handleReadAcks", "payloads", "isOneToOne", "isContact", "handleReceiverMediaPayload", "handleSendConfidentialMessage", "handleSendPayload", "handleUnBlockDialog", "handleUnBlockOption", "handleUpdatingContact", "hasContact", "existedContact", "handleVoiceNoteViews", "handlingGroupText", "handlingGroupTextOne", "handlingGroupTextSeconds", "handlingGroupTextThird", "handlingMediaPayloadClick", "hasContentFor", "", "initAdapter", "initViews", "initializeEmoji", "leaveGroup", "i", "listeners", "loadMessage", "loadMessages", "loadNotifyMessage", "menuAddContact", "menuBlock", "menuDelete", "menuDisappearingMessage", "menuExitLeave", "menuMediaGallery", "menuUnblock", "messageWrapper", "notifyExpiry", "observers", "onActionSelected", "action", "Lcom/devbeans/io/chat/utils/views/ConversationReactionOverlay$Action;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAddAttachments", "onBackPressed", "onClick", "dialogInterface", "Landroid/content/DialogInterface;", "onConfidentialClick", "messages", "adapterPosition", "bubbleView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFailure", "call", "Lretrofit2/Call;", "response", "Lcom/devbeans/io/chat/network/serializers/response/BaseResponse;", "tag", "", "onHide", "onLoadMore", "page", "totalItemsCount", "onLongClick", "view", "onMessageViewClick", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onRecordCanceled", "onRecordHideEvent", "onRecordLocked", "onRecordMoved", "offsetX", "", "absoluteX", "onRecordPermissionRequired", "onRecordPressed", "onRecordReleased", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onStart", "onStop", "onSubmit", "onSuccess", "Lretrofit2/Response;", "onViewOnceClicked", "releaseAudioPlayer", "removedFromConvo", "actualPayload", "conversationId", "requestPermissions", "resetAllModes", "scheduleExpiry", "payload1", "sendOfflineAck", "sendOfflineAckTwo", "setChatMenuToggle", "binding", "setChatScreenBackground", "setColorChatBackground", "setConversation", "setMembersName", "setMenuOptionListeners", "setRoomData", "setToolBar", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "setTopMenu", "showAddContactDialog", "showBlockUserDialog", "showCustomDialog", "showDeleteDialog", "startChatDetails", "startDisappearingActivity", "startHide", "startMediaDetailsActivity", "startObserver", "startShareToActivity", "stopRecording", "unblock", "updateInConversation", "updateMessage", "uploadFile", "uploadForwardFile", "Companion", "app_debug"})
public final class ChatActivity extends com.devbeans.io.chat.verifypin.BaseActivity implements com.stfalcon.chatkit.messages.MessagesListAdapter.OnLoadMoreListener, com.stfalcon.chatkit.messages.MessageInput.InputListener, com.stfalcon.chatkit.messages.MessageInput.AttachmentsListener, com.stfalcon.chatkit.messages.MessageHolders.ContentChecker<com.devbeans.io.chat.models.Messages>, android.content.DialogInterface.OnClickListener, com.devbeans.io.chat.network.OnNetworkResponse, com.stfalcon.chatkit.messages.MessagesListAdapter.OnMessageViewClickListener<com.devbeans.io.chat.models.Messages>, com.devbeans.io.chat.utils.views.ConversationReactionOverlay.OnActionSelectedListener, com.devbeans.io.chat.utils.views.ConversationReactionOverlay.OnHideListener, com.devbeans.io.chat.utils.views.MicrophoneRecorderView.Listener, com.devbeans.io.chat.callBacks.ExpiryCallback {
    private boolean viewOnce = false;
    private boolean canSendAudio = true;
    private com.devbeans.io.chat.models.Payload payloadToForward;
    @org.jetbrains.annotations.Nullable
    private java.lang.String senderId;
    @org.jetbrains.annotations.Nullable
    private com.stfalcon.chatkit.commons.ImageLoader imageLoader;
    private androidx.appcompat.app.AlertDialog mCreateDialog;
    private java.util.Date lastLoadedDate;
    private boolean isToggle = false;
    private com.devbeans.io.chat.databinding.CustomMenuBinding menuBinding;
    private android.widget.PopupWindow mPop;
    private int conversation_pk = 0;
    private com.devbeans.io.chat.utils.Loading loader;
    private androidx.constraintlayout.widget.ConstraintLayout recordingContainer;
    private com.devbeans.io.chat.utils.RecordTime recordTime;
    private com.devbeans.io.chat.utils.SlideToCancel slideToCancel;
    private com.devbeans.io.chat.utils.AudioRecorder audioRecorder;
    private com.devbeans.io.chat.utils.VoiceRecorderWakeLock voiceRecorderWakeLock;
    private final int REQUEST_CODE = 1012;
    @org.jetbrains.annotations.Nullable
    @kotlin.jvm.JvmField
    public com.devbeans.io.chat.models.Conversation conversation;
    @org.jetbrains.annotations.Nullable
    private java.io.File file;
    @org.jetbrains.annotations.Nullable
    private java.lang.String filePath;
    @org.jetbrains.annotations.Nullable
    private java.lang.String mediaType;
    @org.jetbrains.annotations.Nullable
    private java.lang.String type;
    @org.jetbrains.annotations.Nullable
    private java.lang.String mName;
    @org.jetbrains.annotations.Nullable
    private java.lang.String groupName;
    private boolean isBlocked = false;
    private boolean isForwarded = false;
    private boolean isFromForwardUpload = false;
    @org.jetbrains.annotations.Nullable
    private com.devbeans.io.chat.databinding.ActivityChatBinding mBinding;
    @org.jetbrains.annotations.Nullable
    private com.devbeans.io.chat.viewmodels.ChatViewModel mViewModel;
    @org.jetbrains.annotations.Nullable
    private com.devbeans.io.chat.models.ChatRoom mRoom;
    private com.vanniktech.emoji.EmojiPopup mPopup;
    @org.jetbrains.annotations.NotNull
    private java.util.List<? extends com.devbeans.io.chat.models.Message> messageList;
    @org.jetbrains.annotations.Nullable
    private java.util.List<com.devbeans.io.chat.models.Contact> groupMembers;
    private com.devbeans.io.chat.models.Contact mContact;
    private com.devbeans.io.chat.models.Contact NewContact;
    private boolean mIsContact = false;
    private com.devbeans.io.chat.models.User mUser;
    private boolean contactAdded = false;
    @org.jetbrains.annotations.Nullable
    private com.devbeans.io.chat.models.Messages editingMessage;
    private java.io.File mFile;
    private java.io.File img_file;
    private final java.lang.String UNBLOCK = "Unblock";
    private final java.lang.String BLOCK = "Block";
    private final java.lang.String DELETE = "Delete";
    private final java.lang.String CLEAR = "Clear";
    private final java.lang.String LEAVE_GROUP = "Leave Group";
    private final java.lang.String DELETE_GROUP = "Delete Group";
    private final java.lang.String CHANGE_OWNER = "Change Owner";
    private androidx.recyclerview.widget.ItemTouchHelper itemTouchHelper;
    private int selected_time = 1800000;
    private com.devbeans.io.chat.utils.views.ConversationReactionDelegate reactionDelegate;
    private com.devbeans.io.chat.models.ConversationMember member;
    private com.devbeans.io.chat.utils.components.menu.ChatContextMenu activeContextMenu;
    private final android.content.BroadcastReceiver mCommandReceiver = null;
    @org.jetbrains.annotations.Nullable
    private byte[] uploadingSecreteFingerprint;
    @org.jetbrains.annotations.Nullable
    private java.lang.String avRatchetKeyMaterial;
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.activities.ChatActivity.Companion Companion = null;
    private static final int TOTAL_MESSAGES_COUNT = 10;
    @org.jetbrains.annotations.Nullable
    private static com.devbeans.io.chat.adapters.MessageAdapter<com.devbeans.io.chat.models.Messages> adapter;
    private static final byte CONTENT_TYPE_VOICE = (byte)1;
    private static final byte CONTENT_TYPE_FILE = (byte)2;
    private static final byte CONTENT_TYPE_VIDEO = (byte)3;
    private static final byte CONTENT_TYPE_IMAGE = (byte)4;
    private static final byte CONTENT_TYPE_NOTIFY = (byte)5;
    private static final byte CONTENT_TYPE_CONFIDENTIAL = (byte)6;
    private static final byte CONTENT_TYPE_VIEW_ONCE = (byte)7;
    private static final byte CONTENT_TYPE_IS_SELF_EXPIRY = (byte)8;
    @org.jetbrains.annotations.Nullable
    @kotlin.jvm.JvmField
    public static com.devbeans.io.chat.activities.ChatActivity instance;
    private static boolean isEditMode = false;
    private static boolean isDeleteMode = false;
    private static final java.lang.String TAG = null;
    
    public ChatActivity() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getSenderId() {
        return null;
    }
    
    public final void setSenderId(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    protected final com.stfalcon.chatkit.commons.ImageLoader getImageLoader() {
        return null;
    }
    
    protected final void setImageLoader(@org.jetbrains.annotations.Nullable
    com.stfalcon.chatkit.commons.ImageLoader p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.io.File getFile() {
        return null;
    }
    
    public final void setFile(@org.jetbrains.annotations.Nullable
    java.io.File p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getFilePath() {
        return null;
    }
    
    public final void setFilePath(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getMediaType() {
        return null;
    }
    
    public final void setMediaType(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getType() {
        return null;
    }
    
    public final void setType(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getMName() {
        return null;
    }
    
    public final void setMName(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getGroupName() {
        return null;
    }
    
    public final void setGroupName(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    public final boolean isBlocked() {
        return false;
    }
    
    public final void setBlocked(boolean p0) {
    }
    
    public final boolean isForwarded() {
        return false;
    }
    
    public final void setForwarded(boolean p0) {
    }
    
    public final boolean isFromForwardUpload() {
        return false;
    }
    
    public final void setFromForwardUpload(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.databinding.ActivityChatBinding getMBinding() {
        return null;
    }
    
    public final void setMBinding(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.databinding.ActivityChatBinding p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.viewmodels.ChatViewModel getMViewModel() {
        return null;
    }
    
    public final void setMViewModel(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.viewmodels.ChatViewModel p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.models.ChatRoom getMRoom() {
        return null;
    }
    
    public final void setMRoom(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.models.ChatRoom p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.devbeans.io.chat.models.Message> getMessageList() {
        return null;
    }
    
    public final void setMessageList(@org.jetbrains.annotations.NotNull
    java.util.List<? extends com.devbeans.io.chat.models.Message> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.devbeans.io.chat.models.Contact> getGroupMembers() {
        return null;
    }
    
    public final void setGroupMembers(@org.jetbrains.annotations.Nullable
    java.util.List<com.devbeans.io.chat.models.Contact> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.models.Messages getEditingMessage() {
        return null;
    }
    
    public final void setEditingMessage(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.models.Messages p0) {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.R)
    @java.lang.Override
    protected void onResume() {
    }
    
    /**
     * Initializes views and sets up the chat screen.
     */
    public final void initViews() {
    }
    
    private final void setTopMenu(com.devbeans.io.chat.databinding.ActivityChatBinding binding) {
    }
    
    /**
     * Get menu items based on the conversation type and conditions.
     *
     * @return MutableList<ActionItem> - A list of action items for the menu.
     */
    private final java.util.List<com.devbeans.io.chat.utils.views.ActionItem> getMenuItems() {
        return null;
    }
    
    /**
     * Set up the chat menu toggle functionality.
     *
     * @param binding The ActivityChatBinding object.
     */
    @android.annotation.SuppressLint(value = {"RtlHardcoded"})
    private final void setChatMenuToggle(com.devbeans.io.chat.databinding.ActivityChatBinding binding) {
    }
    
    private final void handleMenuVisibility(com.devbeans.io.chat.databinding.CustomMenuBinding customMenuBinding) {
    }
    
    private final int menuDelete() {
        return 0;
    }
    
    private final int menuExitLeave() {
        return 0;
    }
    
    private final int menuUnblock() {
        return 0;
    }
    
    private final int menuBlock() {
        return 0;
    }
    
    private final int menuDisappearingMessage() {
        return 0;
    }
    
    private final int menuMediaGallery() {
        return 0;
    }
    
    private final int menuAddContact() {
        return 0;
    }
    
    /**
     * Set listeners for options menu.
     */
    private final void setMenuOptionListeners() {
    }
    
    private final void handleUnBlockOption() {
    }
    
    private final void handleBlockOption() {
    }
    
    private final void handleDisappearOption() {
    }
    
    private final void handleAddContactOption() {
    }
    
    private final void setChatScreenBackground() {
    }
    
    private final void setColorChatBackground() {
    }
    
    public final void setConversation(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.models.Conversation conversation) {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    protected void onStart() {
    }
    
    public final void handleSendConfidentialMessage() {
    }
    
    public final void handleNewConSendConfidentialMessage() {
    }
    
    private final void handleEnterToSent() {
    }
    
    private final void handleReaction() {
    }
    
    /**
     * Loads a message into the conversation's chat view by adding it to the adapter and sending an "ack_read" payload to
     * indicate that the message has been read.
     *
     * @param payload The message payload to load.
     */
    public final void loadMessage(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Payload payload) {
    }
    
    private final boolean checkIsContact(boolean oneToOne, com.devbeans.io.chat.models.Payload payload) {
        return false;
    }
    
    private final com.devbeans.io.chat.models.Messages messageWrapper(com.devbeans.io.chat.models.Payload payload) {
        return null;
    }
    
    private final boolean checkPayloadWithConversation(com.devbeans.io.chat.models.Payload payload) {
        return false;
    }
    
    public final void loadNotifyMessage(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.models.Payload payload) {
    }
    
    private final void initializeEmoji() {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.R)
    private final void listeners() {
    }
    
    private final void handleCopyClick() {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    private final void handlePastClick() {
    }
    
    private final void handleOnStopTyping() {
    }
    
    private final void handleOnStartTyping() {
    }
    
    private final void handleAttachmentPopup() {
    }
    
    private final void fadeIn(android.view.View v) {
    }
    
    private final void fadeOut(android.view.View v) {
    }
    
    private final void showAddContactDialog() {
    }
    
    private final void handleAddContactDialogButton(com.devbeans.io.chat.databinding.CustomDailogAddContactBinding mCreateDialogBinding) {
    }
    
    private final void handleNewContactAdding(com.devbeans.io.chat.models.Contact contact) {
    }
    
    private final void handleUpdatingContact(com.devbeans.io.chat.models.Contact contact, boolean hasContact, com.devbeans.io.chat.models.Contact existedContact, com.devbeans.io.chat.databinding.CustomDailogAddContactBinding mCreateDialogBinding) {
    }
    
    private final void startShareToActivity() {
    }
    
    private final void startChatDetails() {
    }
    
    private final void startMediaDetailsActivity() {
    }
    
    private final void startDisappearingActivity() {
    }
    
    private final kotlin.Unit getProfileData() {
        return null;
    }
    
    private final void observers() {
    }
    
    private final void clearConversationChat() {
    }
    
    public final void clearChat() {
    }
    
    public final void deleteExpiryMessage(@org.jetbrains.annotations.Nullable
    java.lang.String id) {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    private final kotlin.Unit getRoomData() {
        return null;
    }
    
    /**
     * Get the Read receipts keeping in mind the
     * General Read receipts and also read receipts of current conversation
     */
    private final boolean getReadReceipt() {
        return false;
    }
    
    /**
     * Update that user is in particular converastion and also update other conversation
     */
    private final void updateInConversation() {
    }
    
    public final void setMembersName() {
    }
    
    private final void handleGroupMemberAnon(java.util.List<com.devbeans.io.chat.models.ConversationMember> conMembers) {
    }
    
    private final void handlingGroupTextOne(com.devbeans.io.chat.models.ConversationMember member, com.devbeans.io.chat.models.Contact contact) {
    }
    
    private final void handlingGroupText(com.devbeans.io.chat.models.ConversationMember member, com.devbeans.io.chat.models.Contact contact) {
    }
    
    private final void handleGroupMember(java.util.List<com.devbeans.io.chat.models.ConversationMember> conMembers) {
    }
    
    private final void handlingGroupTextThird(com.devbeans.io.chat.models.ConversationMember member, com.devbeans.io.chat.models.Contact contact) {
    }
    
    private final void handlingGroupTextSeconds(com.devbeans.io.chat.models.ConversationMember member, com.devbeans.io.chat.models.Contact contact) {
    }
    
    private final void setRoomData() {
    }
    
    private final void setToolBar(androidx.appcompat.widget.Toolbar toolbar) {
    }
    
    @androidx.annotation.MainThread
    @java.lang.Override
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull
    android.view.MenuItem item) {
        return false;
    }
    
    private final void showDeleteDialog() {
    }
    
    /**
     * Show a custom dialog based on the given integer parameter.
     *
     * @param i the integer that determines which dialog to show
     */
    private final void showCustomDialog(int i) {
    }
    
    private final void handleUnBlockDialog() {
    }
    
    private final void handleBlockDialog() {
    }
    
    private final void handleLeaveGroup(com.devbeans.io.chat.databinding.CustomBlockDailogBinding dialogBinding) {
    }
    
    /**
     * Unblocks the user by calling the API to unblock the user and logs the request details.
     */
    private final void unblock() {
    }
    
    /**
     * Block the current user from the chat with the other user in the conversation
     */
    private final void blockUser() {
    }
    
    private final com.devbeans.io.chat.models.Contact checkContactNull(java.lang.String memberID) {
        return null;
    }
    
    /**
     * Delete the currently editing message from the chat screen.
     *
     * @param deletionType The type of deletion - "me" for deleting only the current user's message,
     * or "everyone" for deleting the message for everyone in the conversation.
     */
    private final void deleteMessage(java.lang.String deletionType) {
    }
    
    /**
     * Deletes the file associated with the given message payload.
     *
     * @param payload The message payload containing the file path to delete.
     */
    private final void deleteMessageFile(com.devbeans.io.chat.models.Payload payload) {
    }
    
    private final void leaveGroup(int i) {
    }
    
    /**
     * Resets all the modes of the chat UI such as edit, delete, etc. and updates the adapter accordingly.
     */
    private final void resetAllModes() {
    }
    
    @java.lang.Override
    public void onLoadMore(int page, int totalItemsCount) {
    }
    
    /**
     * Loads messages for the current conversation.
     */
    public final void loadMessages() {
    }
    
    /**
     * Handles read acks for the given payloads. Updates the message status to SEEN and schedules message expiry
     * for the delivered messages that are not sent by the current user.
     *
     * @param payloads The list of payloads for which read acks need to be handled.
     * @param isOneToOne A boolean flag indicating if the conversation is one-to-one.
     * @param isContact A boolean flag indicating if the conversation is with a contact.
     */
    private final void handleReadAcks(java.util.List<com.devbeans.io.chat.models.Payload> payloads, boolean isOneToOne, boolean isContact) {
    }
    
    /**
     * Sends an offline acknowledgement for the given payload if necessary.
     *
     * @param isOneToOne Whether the conversation is one-to-one.
     * @param isContact Whether the conversation is with a contact.
     * @param payload1 The payload to send as an acknowledgement.
     * @param payload The original payload that was sent.
     */
    private final void sendOfflineAckTwo(boolean isOneToOne, boolean isContact, com.devbeans.io.chat.models.Payload payload1, com.devbeans.io.chat.models.Payload payload) {
    }
    
    /**
     * Sends an offline acknowledgement for the given payload if necessary.
     *
     * @param isOneToOne Whether the conversation is one-to-one.
     * @param isContact Whether the conversation is with a contact.
     * @param payload1 The payload to send as an acknowledgement.
     * @param payload The original payload that was sent.
     */
    private final void sendOfflineAck(boolean isOneToOne, boolean isContact, com.devbeans.io.chat.models.Payload payload1, com.devbeans.io.chat.models.Payload payload) {
    }
    
    /**
     * Schedules the expiry of the given payload if necessary.
     *
     * @param payload1 The payload to schedule for expiry.
     */
    private final void scheduleExpiry(com.devbeans.io.chat.models.Payload payload1) {
    }
    
    @java.lang.Override
    public void onBackPressed() {
    }
    
    @java.lang.Override
    public void onClick(@org.jetbrains.annotations.NotNull
    android.content.DialogInterface dialogInterface, int i) {
    }
    
    @java.lang.Override
    public void onAddAttachments() {
    }
    
    /**
     * This method will be responsible for sending the File type according to its extension
     *
     * @param requestCode this is the code which is requested on start of activity intent gallery
     * @param resultCode  this is the result code which is gotten in the response of activity start
     * @param data        this is the data which is gotten after activity intent we will evaluate only URI
     */
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    @java.lang.Override
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable
    android.content.Intent data) {
    }
    
    public final void CreateMainSymmeticHandshake(@org.jetbrains.annotations.NotNull
    java.lang.String conversation_id, @org.jetbrains.annotations.Nullable
    java.lang.CharSequence sentMessage, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.models.Payload messagePayload) {
    }
    
    @java.lang.Override
    public boolean onSubmit(@org.jetbrains.annotations.NotNull
    java.lang.CharSequence input) {
        return false;
    }
    
    private final void handleVoiceNoteViews() {
    }
    
    private final void handleNormalPayload(java.lang.CharSequence input) {
    }
    
    private final void handleEditPayload(java.lang.CharSequence input) {
    }
    
    private final void handleSendPayload(java.lang.CharSequence input, com.devbeans.io.chat.models.Payload payload) {
    }
    
    private final void showBlockUserDialog() {
    }
    
    @java.lang.Override
    public boolean hasContentFor(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Messages message, byte type) {
        return false;
    }
    
    public final void initAdapter() {
    }
    
    public final void deleteById(@org.jetbrains.annotations.NotNull
    java.lang.String id) {
    }
    
    public final void createNewConversation(@org.jetbrains.annotations.NotNull
    java.util.Map<java.lang.String, ? extends okhttp3.RequestBody> map) {
    }
    
    public final void createNewConversation(@org.jetbrains.annotations.NotNull
    java.lang.String type, @org.jetbrains.annotations.NotNull
    java.lang.String member, @org.jetbrains.annotations.NotNull
    java.lang.String userChatId, @org.jetbrains.annotations.NotNull
    java.lang.String description, @org.jetbrains.annotations.NotNull
    java.lang.String name, long selectedTime) {
    }
    
    public final void createAnonymousNewConversation(@org.jetbrains.annotations.NotNull
    java.util.Map<java.lang.String, ? extends okhttp3.RequestBody> map) {
    }
    
    public final void createAnonymousNewConversation(@org.jetbrains.annotations.NotNull
    java.lang.String type, @org.jetbrains.annotations.NotNull
    java.lang.String member, @org.jetbrains.annotations.NotNull
    java.lang.String userChatId, @org.jetbrains.annotations.NotNull
    java.lang.String description, @org.jetbrains.annotations.NotNull
    java.lang.String name, long selectedTime) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final byte[] getUploadingSecreteFingerprint() {
        return null;
    }
    
    public final void setUploadingSecreteFingerprint(@org.jetbrains.annotations.Nullable
    byte[] p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getAvRatchetKeyMaterial() {
        return null;
    }
    
    public final void setAvRatchetKeyMaterial(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    private final void uploadFile() {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    private final void uploadForwardFile() {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    @java.lang.Override
    public void onSuccess(@org.jetbrains.annotations.Nullable
    retrofit2.Call<?> call, @org.jetbrains.annotations.NotNull
    retrofit2.Response<?> response, @org.jetbrains.annotations.NotNull
    java.lang.Object tag) {
    }
    
    @java.lang.Override
    public void onFailure(@org.jetbrains.annotations.Nullable
    retrofit2.Call<?> call, @org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.network.serializers.response.BaseResponse response, @org.jetbrains.annotations.NotNull
    java.lang.Object tag) {
    }
    
    @java.lang.Override
    public void onMessageViewClick(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Messages message) {
    }
    
    private final void handleReceiverMediaPayload(com.devbeans.io.chat.models.Messages message) {
    }
    
    private final void handlingMediaPayloadClick(com.devbeans.io.chat.models.Messages message) {
    }
    
    private final boolean checkViewClickPayload(com.devbeans.io.chat.models.Messages message) {
        return false;
    }
    
    @java.lang.Override
    protected void onStop() {
    }
    
    public final void updateMessage(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.models.Payload payload) {
    }
    
    @java.lang.Override
    protected void onDestroy() {
    }
    
    public final void onLongClick(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Messages messages, int adapterPosition, @org.jetbrains.annotations.NotNull
    android.view.View view) {
    }
    
    @java.lang.Override
    public boolean dispatchTouchEvent(@org.jetbrains.annotations.Nullable
    android.view.MotionEvent ev) {
        return false;
    }
    
    public final void conversationRemoved() {
    }
    
    public final void removedFromConvo(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Payload actualPayload) {
    }
    
    public final void removedFromConvo(@org.jetbrains.annotations.NotNull
    java.lang.String conversationId) {
    }
    
    public final void addedInConversation() {
    }
    
    public final void startObserver(@org.jetbrains.annotations.Nullable
    java.io.File img_file) {
    }
    
    public final void autoSaveToVault(@org.jetbrains.annotations.NotNull
    java.lang.String path) {
    }
    
    @org.jetbrains.annotations.Nullable
    @kotlin.jvm.JvmStatic
    public static final com.devbeans.io.chat.activities.ChatActivity getInstance() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @kotlin.jvm.JvmStatic
    public static final com.devbeans.io.chat.activities.ChatActivity getChatInstance() {
        return null;
    }
    
    @java.lang.Override
    public void onActionSelected(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.utils.views.ConversationReactionOverlay.Action action) {
    }
    
    @java.lang.Override
    public void startHide() {
    }
    
    @java.lang.Override
    public void onHide() {
    }
    
    private final long onRecordHideEvent(java.lang.String tag) {
        return 0L;
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.R)
    private final void requestPermissions() {
    }
    
    @java.lang.Override
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull
    int[] grantResults) {
    }
    
    private final boolean checkPermission() {
        return false;
    }
    
    public final void onConfidentialClick(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Messages messages, int adapterPosition, @org.jetbrains.annotations.NotNull
    androidx.constraintlayout.widget.ConstraintLayout bubbleView) {
    }
    
    public final void onViewOnceClicked(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Messages message) {
    }
    
    @java.lang.Override
    public void onRecordPressed() {
    }
    
    @java.lang.Override
    public void onRecordReleased() {
    }
    
    private final void releaseAudioPlayer() {
    }
    
    private final void stopRecording() {
    }
    
    @java.lang.Override
    public void onRecordCanceled() {
    }
    
    @java.lang.Override
    public void onRecordLocked() {
    }
    
    @java.lang.Override
    public void onRecordMoved(float offsetX, float absoluteX) {
    }
    
    @java.lang.Override
    public void onRecordPermissionRequired() {
    }
    
    @java.lang.Override
    public void notifyExpiry() {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u001f\u001a\u00020\u001d2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00150!2\b\u0010\"\u001a\u0004\u0018\u00010\rJ \u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020(J\n\u0010*\u001a\u0004\u0018\u00010\u001bH\u0007J\n\u0010+\u001a\u0004\u0018\u00010\u001bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0019\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082T\u00a2\u0006\u0002\n\u0000R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2 = {"Lcom/devbeans/io/chat/activities/ChatActivity$Companion;", "", "()V", "CONTENT_TYPE_CONFIDENTIAL", "", "CONTENT_TYPE_FILE", "CONTENT_TYPE_IMAGE", "CONTENT_TYPE_IS_SELF_EXPIRY", "CONTENT_TYPE_NOTIFY", "CONTENT_TYPE_VIDEO", "CONTENT_TYPE_VIEW_ONCE", "CONTENT_TYPE_VOICE", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "TOTAL_MESSAGES_COUNT", "", "adapter", "Lcom/devbeans/io/chat/adapters/MessageAdapter;", "Lcom/devbeans/io/chat/models/Messages;", "getAdapter", "()Lcom/devbeans/io/chat/adapters/MessageAdapter;", "setAdapter", "(Lcom/devbeans/io/chat/adapters/MessageAdapter;)V", "instance", "Lcom/devbeans/io/chat/activities/ChatActivity;", "isDeleteMode", "", "isEditMode", "containMessage", "list", "", "messageID", "createTransitionBundle", "Landroid/os/Bundle;", "context", "Landroid/content/Context;", "avatar", "Landroid/view/View;", "windowContent", "getChatInstance", "getInstance", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable
        public final com.devbeans.io.chat.adapters.MessageAdapter<com.devbeans.io.chat.models.Messages> getAdapter() {
            return null;
        }
        
        public final void setAdapter(@org.jetbrains.annotations.Nullable
        com.devbeans.io.chat.adapters.MessageAdapter<com.devbeans.io.chat.models.Messages> p0) {
        }
        
        public final java.lang.String getTAG() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        @kotlin.jvm.JvmStatic
        public final com.devbeans.io.chat.activities.ChatActivity getInstance() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        @kotlin.jvm.JvmStatic
        public final com.devbeans.io.chat.activities.ChatActivity getChatInstance() {
            return null;
        }
        
        public final boolean containMessage(@org.jetbrains.annotations.NotNull
        java.util.List<? extends com.devbeans.io.chat.models.Messages> list, @org.jetbrains.annotations.Nullable
        java.lang.String messageID) {
            return false;
        }
        
        @org.jetbrains.annotations.Nullable
        public final android.os.Bundle createTransitionBundle(@org.jetbrains.annotations.NotNull
        android.content.Context context, @org.jetbrains.annotations.NotNull
        android.view.View avatar, @org.jetbrains.annotations.NotNull
        android.view.View windowContent) {
            return null;
        }
    }
}