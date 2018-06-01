  global                 main
  extern               printf
  extern               malloc
  extern               strcpy
  extern                scanf
  extern               strlen
  extern               sscanf
  extern              sprintf
  extern               memcpy
  extern               strcmp
  extern                 puts

section	.text
@GlobalDeclaration:
    push                  rbp
     mov                  rbp,                  rsp
@GlobalDeclaration.0.enter:
     jmp @GlobalDeclaration.1.exit
@GlobalDeclaration.1.exit:
     pop                  rbp
     ret
main:
    push                  rbp
     mov                  rbp,                  rsp
    call   @GlobalDeclaration
     sub                  rsp,                 2984
main.0.enter:
     mov                  rax,   _string_constant_0
     mov      qword [rbp - 8],                  rax
     mov                  rax,   _string_constant_1
     mov     qword [rbp - 16],                  rax
     mov                  rax,   _string_constant_2
     mov     qword [rbp - 24],                  rax
     mov                  rdi,     qword [rbp - 24]
     mov                  rsi,     qword [rbp - 16]
    push     qword [rbp - 16]
    call         _builtin_add
     add                  rsp,                    8
     mov     qword [rbp - 56],                  rax
     mov                  rdi,     qword [rbp - 56]
     mov                  rsi,     qword [rbp - 16]
    push     qword [rbp - 16]
    call         _builtin_add
     add                  rsp,                    8
     mov     qword [rbp - 88],                  rax
     mov                  rdi,     qword [rbp - 88]
     mov                  rsi,     qword [rbp - 24]
    push     qword [rbp - 24]
    call         _builtin_add
     add                  rsp,                    8
     mov    qword [rbp - 120],                  rax
     mov                  rdi,    qword [rbp - 120]
     mov                  rsi,     qword [rbp - 24]
    push     qword [rbp - 24]
    call         _builtin_add
     add                  rsp,                    8
     mov    qword [rbp - 152],                  rax
     mov                  rdi,    qword [rbp - 152]
     mov                  rsi,      qword [rbp - 8]
    push      qword [rbp - 8]
    call         _builtin_add
     add                  rsp,                    8
     mov    qword [rbp - 184],                  rax
     mov                  rdi,    qword [rbp - 184]
     mov                  rsi,     qword [rbp - 24]
    push     qword [rbp - 24]
    call         _builtin_add
     add                  rsp,                    8
     mov    qword [rbp - 216],                  rax
     mov                  rdi,    qword [rbp - 216]
     mov                  rsi,     qword [rbp - 16]
    push     qword [rbp - 16]
    call         _builtin_add
     add                  rsp,                    8
     mov    qword [rbp - 248],                  rax
     mov                  rdi,    qword [rbp - 248]
     mov                  rsi,     qword [rbp - 24]
    push     qword [rbp - 24]
    call         _builtin_add
     add                  rsp,                    8
     mov    qword [rbp - 280],                  rax
     mov                  rdi,    qword [rbp - 280]
     mov                  rsi,     qword [rbp - 16]
    push     qword [rbp - 16]
    call         _builtin_add
     add                  rsp,                    8
     mov    qword [rbp - 312],                  rax
     mov                  rdi,    qword [rbp - 312]
     sub                  rsp,                    8
    call                print
     add                  rsp,                    8
     mov                  rdi,     qword [rbp - 24]
     mov                  rsi,     qword [rbp - 24]
    push     qword [rbp - 24]
    call         _builtin_add
     add                  rsp,                    8
     mov    qword [rbp - 352],                  rax
     mov                  rdi,    qword [rbp - 352]
     mov                  rsi,      qword [rbp - 8]
    push      qword [rbp - 8]
    call         _builtin_add
     add                  rsp,                    8
     mov    qword [rbp - 384],                  rax
     mov                  rdi,    qword [rbp - 384]
     mov                  rsi,      qword [rbp - 8]
    push      qword [rbp - 8]
    call         _builtin_add
     add                  rsp,                    8
     mov    qword [rbp - 416],                  rax
     mov                  rdi,    qword [rbp - 416]
     mov                  rsi,      qword [rbp - 8]
    push      qword [rbp - 8]
    call         _builtin_add
     add                  rsp,                    8
     mov    qword [rbp - 448],                  rax
     mov                  rdi,    qword [rbp - 448]
     mov                  rsi,     qword [rbp - 24]
    push     qword [rbp - 24]
    call         _builtin_add
     add                  rsp,                    8
     mov    qword [rbp - 480],                  rax
     mov                  rdi,    qword [rbp - 480]
     mov                  rsi,     qword [rbp - 24]
    push     qword [rbp - 24]
    call         _builtin_add
     add                  rsp,                    8
     mov    qword [rbp - 512],                  rax
     mov                  rdi,    qword [rbp - 512]
     mov                  rsi,     qword [rbp - 16]
    push     qword [rbp - 16]
    call         _builtin_add
     add                  rsp,                    8
     mov    qword [rbp - 544],                  rax
     mov                  rdi,    qword [rbp - 544]
     mov                  rsi,     qword [rbp - 16]
    push     qword [rbp - 16]
    call         _builtin_add
     add                  rsp,                    8
     mov    qword [rbp - 576],                  rax
     mov                  rdi,    qword [rbp - 576]
     mov                  rsi,     qword [rbp - 16]
    push     qword [rbp - 16]
    call         _builtin_add
     add                  rsp,                    8
     mov    qword [rbp - 608],                  rax
     mov                  rdi,    qword [rbp - 608]
     sub                  rsp,                    8
    call                print
     add                  rsp,                    8
     mov                  rdi,     qword [rbp - 16]
     mov                  rsi,      qword [rbp - 8]
    push      qword [rbp - 8]
    call         _builtin_add
     add                  rsp,                    8
     mov    qword [rbp - 648],                  rax
     mov                  rdi,    qword [rbp - 648]
     mov                  rsi,     qword [rbp - 24]
    push     qword [rbp - 24]
    call         _builtin_add
     add                  rsp,                    8
     mov    qword [rbp - 680],                  rax
     mov                  rdi,    qword [rbp - 680]
     mov                  rsi,     qword [rbp - 16]
    push     qword [rbp - 16]
    call         _builtin_add
     add                  rsp,                    8
     mov    qword [rbp - 712],                  rax
     mov                  rdi,    qword [rbp - 712]
     mov                  rsi,     qword [rbp - 24]
    push     qword [rbp - 24]
    call         _builtin_add
     add                  rsp,                    8
     mov    qword [rbp - 744],                  rax
     mov                  rdi,    qword [rbp - 744]
     mov                  rsi,     qword [rbp - 24]
    push     qword [rbp - 24]
    call         _builtin_add
     add                  rsp,                    8
     mov    qword [rbp - 776],                  rax
     mov                  rdi,    qword [rbp - 776]
     mov                  rsi,     qword [rbp - 16]
    push     qword [rbp - 16]
    call         _builtin_add
     add                  rsp,                    8
     mov    qword [rbp - 808],                  rax
     mov                  rdi,    qword [rbp - 808]
     mov                  rsi,     qword [rbp - 16]
    push     qword [rbp - 16]
    call         _builtin_add
     add                  rsp,                    8
     mov    qword [rbp - 840],                  rax
     mov                  rdi,    qword [rbp - 840]
     mov                  rsi,      qword [rbp - 8]
    push      qword [rbp - 8]
    call         _builtin_add
     add                  rsp,                    8
     mov    qword [rbp - 872],                  rax
     mov                  rdi,    qword [rbp - 872]
     mov                  rsi,     qword [rbp - 24]
    push     qword [rbp - 24]
    call         _builtin_add
     add                  rsp,                    8
     mov    qword [rbp - 904],                  rax
     mov                  rdi,    qword [rbp - 904]
     sub                  rsp,                    8
    call                print
     add                  rsp,                    8
     mov                  rdi,     qword [rbp - 16]
     mov                  rsi,      qword [rbp - 8]
    push      qword [rbp - 8]
    call         _builtin_add
     add                  rsp,                    8
     mov    qword [rbp - 944],                  rax
     mov                  rdi,    qword [rbp - 944]
     mov                  rsi,     qword [rbp - 24]
    push     qword [rbp - 24]
    call         _builtin_add
     add                  rsp,                    8
     mov    qword [rbp - 976],                  rax
     mov                  rdi,    qword [rbp - 976]
     mov                  rsi,      qword [rbp - 8]
    push      qword [rbp - 8]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 1008],                  rax
     mov                  rdi,   qword [rbp - 1008]
     mov                  rsi,      qword [rbp - 8]
    push      qword [rbp - 8]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 1040],                  rax
     mov                  rdi,   qword [rbp - 1040]
     mov                  rsi,      qword [rbp - 8]
    push      qword [rbp - 8]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 1072],                  rax
     mov                  rdi,   qword [rbp - 1072]
     mov                  rsi,     qword [rbp - 16]
    push     qword [rbp - 16]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 1104],                  rax
     mov                  rdi,   qword [rbp - 1104]
     mov                  rsi,     qword [rbp - 16]
    push     qword [rbp - 16]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 1136],                  rax
     mov                  rdi,   qword [rbp - 1136]
     mov                  rsi,     qword [rbp - 16]
    push     qword [rbp - 16]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 1168],                  rax
     mov                  rdi,   qword [rbp - 1168]
     mov                  rsi,     qword [rbp - 24]
    push     qword [rbp - 24]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 1200],                  rax
     mov                  rdi,   qword [rbp - 1200]
     sub                  rsp,                    8
    call                print
     add                  rsp,                    8
     mov                  rdi,     qword [rbp - 16]
     mov                  rsi,      qword [rbp - 8]
    push      qword [rbp - 8]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 1240],                  rax
     mov                  rdi,   qword [rbp - 1240]
     mov                  rsi,     qword [rbp - 16]
    push     qword [rbp - 16]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 1272],                  rax
     mov                  rdi,   qword [rbp - 1272]
     mov                  rsi,      qword [rbp - 8]
    push      qword [rbp - 8]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 1304],                  rax
     mov                  rdi,   qword [rbp - 1304]
     mov                  rsi,     qword [rbp - 24]
    push     qword [rbp - 24]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 1336],                  rax
     mov                  rdi,   qword [rbp - 1336]
     mov                  rsi,     qword [rbp - 24]
    push     qword [rbp - 24]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 1368],                  rax
     mov                  rdi,   qword [rbp - 1368]
     mov                  rsi,     qword [rbp - 24]
    push     qword [rbp - 24]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 1400],                  rax
     mov                  rdi,   qword [rbp - 1400]
     mov                  rsi,     qword [rbp - 16]
    push     qword [rbp - 16]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 1432],                  rax
     mov                  rdi,   qword [rbp - 1432]
     mov                  rsi,     qword [rbp - 24]
    push     qword [rbp - 24]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 1464],                  rax
     mov                  rdi,   qword [rbp - 1464]
     mov                  rsi,      qword [rbp - 8]
    push      qword [rbp - 8]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 1496],                  rax
     mov                  rdi,   qword [rbp - 1496]
     sub                  rsp,                    8
    call                print
     add                  rsp,                    8
     mov                  rdi,      qword [rbp - 8]
     mov                  rsi,      qword [rbp - 8]
    push      qword [rbp - 8]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 1536],                  rax
     mov                  rdi,   qword [rbp - 1536]
     mov                  rsi,     qword [rbp - 24]
    push     qword [rbp - 24]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 1568],                  rax
     mov                  rdi,   qword [rbp - 1568]
     mov                  rsi,     qword [rbp - 24]
    push     qword [rbp - 24]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 1600],                  rax
     mov                  rdi,   qword [rbp - 1600]
     mov                  rsi,      qword [rbp - 8]
    push      qword [rbp - 8]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 1632],                  rax
     mov                  rdi,   qword [rbp - 1632]
     mov                  rsi,     qword [rbp - 24]
    push     qword [rbp - 24]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 1664],                  rax
     mov                  rdi,   qword [rbp - 1664]
     mov                  rsi,     qword [rbp - 16]
    push     qword [rbp - 16]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 1696],                  rax
     mov                  rdi,   qword [rbp - 1696]
     mov                  rsi,     qword [rbp - 24]
    push     qword [rbp - 24]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 1728],                  rax
     mov                  rdi,   qword [rbp - 1728]
     mov                  rsi,     qword [rbp - 24]
    push     qword [rbp - 24]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 1760],                  rax
     mov                  rdi,   qword [rbp - 1760]
     mov                  rsi,      qword [rbp - 8]
    push      qword [rbp - 8]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 1792],                  rax
     mov                  rdi,   qword [rbp - 1792]
     sub                  rsp,                    8
    call                print
     add                  rsp,                    8
     mov                  rdi,     qword [rbp - 16]
     mov                  rsi,     qword [rbp - 16]
    push     qword [rbp - 16]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 1832],                  rax
     mov                  rdi,   qword [rbp - 1832]
     mov                  rsi,     qword [rbp - 16]
    push     qword [rbp - 16]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 1864],                  rax
     mov                  rdi,   qword [rbp - 1864]
     mov                  rsi,     qword [rbp - 16]
    push     qword [rbp - 16]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 1896],                  rax
     mov                  rdi,   qword [rbp - 1896]
     mov                  rsi,     qword [rbp - 24]
    push     qword [rbp - 24]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 1928],                  rax
     mov                  rdi,   qword [rbp - 1928]
     mov                  rsi,      qword [rbp - 8]
    push      qword [rbp - 8]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 1960],                  rax
     mov                  rdi,   qword [rbp - 1960]
     mov                  rsi,     qword [rbp - 24]
    push     qword [rbp - 24]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 1992],                  rax
     mov                  rdi,   qword [rbp - 1992]
     mov                  rsi,     qword [rbp - 16]
    push     qword [rbp - 16]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 2024],                  rax
     mov                  rdi,   qword [rbp - 2024]
     mov                  rsi,      qword [rbp - 8]
    push      qword [rbp - 8]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 2056],                  rax
     mov                  rdi,   qword [rbp - 2056]
     mov                  rsi,      qword [rbp - 8]
    push      qword [rbp - 8]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 2088],                  rax
     mov                  rdi,   qword [rbp - 2088]
     sub                  rsp,                    8
    call                print
     add                  rsp,                    8
     mov                  rdi,      qword [rbp - 8]
     mov                  rsi,      qword [rbp - 8]
    push      qword [rbp - 8]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 2128],                  rax
     mov                  rdi,   qword [rbp - 2128]
     mov                  rsi,     qword [rbp - 24]
    push     qword [rbp - 24]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 2160],                  rax
     mov                  rdi,   qword [rbp - 2160]
     mov                  rsi,     qword [rbp - 16]
    push     qword [rbp - 16]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 2192],                  rax
     mov                  rdi,   qword [rbp - 2192]
     mov                  rsi,      qword [rbp - 8]
    push      qword [rbp - 8]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 2224],                  rax
     mov                  rdi,   qword [rbp - 2224]
     mov                  rsi,     qword [rbp - 16]
    push     qword [rbp - 16]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 2256],                  rax
     mov                  rdi,   qword [rbp - 2256]
     mov                  rsi,     qword [rbp - 24]
    push     qword [rbp - 24]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 2288],                  rax
     mov                  rdi,   qword [rbp - 2288]
     mov                  rsi,     qword [rbp - 24]
    push     qword [rbp - 24]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 2320],                  rax
     mov                  rdi,   qword [rbp - 2320]
     mov                  rsi,     qword [rbp - 16]
    push     qword [rbp - 16]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 2352],                  rax
     mov                  rdi,   qword [rbp - 2352]
     mov                  rsi,     qword [rbp - 16]
    push     qword [rbp - 16]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 2384],                  rax
     mov                  rdi,   qword [rbp - 2384]
     sub                  rsp,                    8
    call                print
     add                  rsp,                    8
     mov                  rdi,     qword [rbp - 24]
     mov                  rsi,     qword [rbp - 16]
    push     qword [rbp - 16]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 2424],                  rax
     mov                  rdi,   qword [rbp - 2424]
     mov                  rsi,      qword [rbp - 8]
    push      qword [rbp - 8]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 2456],                  rax
     mov                  rdi,   qword [rbp - 2456]
     mov                  rsi,      qword [rbp - 8]
    push      qword [rbp - 8]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 2488],                  rax
     mov                  rdi,   qword [rbp - 2488]
     mov                  rsi,     qword [rbp - 24]
    push     qword [rbp - 24]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 2520],                  rax
     mov                  rdi,   qword [rbp - 2520]
     mov                  rsi,     qword [rbp - 16]
    push     qword [rbp - 16]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 2552],                  rax
     mov                  rdi,   qword [rbp - 2552]
     mov                  rsi,      qword [rbp - 8]
    push      qword [rbp - 8]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 2584],                  rax
     mov                  rdi,   qword [rbp - 2584]
     mov                  rsi,      qword [rbp - 8]
    push      qword [rbp - 8]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 2616],                  rax
     mov                  rdi,   qword [rbp - 2616]
     mov                  rsi,     qword [rbp - 24]
    push     qword [rbp - 24]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 2648],                  rax
     mov                  rdi,   qword [rbp - 2648]
     mov                  rsi,     qword [rbp - 16]
    push     qword [rbp - 16]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 2680],                  rax
     mov                  rdi,   qword [rbp - 2680]
     sub                  rsp,                    8
    call                print
     add                  rsp,                    8
     mov                  rdi,      qword [rbp - 8]
     mov                  rsi,     qword [rbp - 24]
    push     qword [rbp - 24]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 2720],                  rax
     mov                  rdi,   qword [rbp - 2720]
     mov                  rsi,     qword [rbp - 16]
    push     qword [rbp - 16]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 2752],                  rax
     mov                  rdi,   qword [rbp - 2752]
     mov                  rsi,     qword [rbp - 16]
    push     qword [rbp - 16]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 2784],                  rax
     mov                  rdi,   qword [rbp - 2784]
     mov                  rsi,     qword [rbp - 16]
    push     qword [rbp - 16]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 2816],                  rax
     mov                  rdi,   qword [rbp - 2816]
     mov                  rsi,     qword [rbp - 24]
    push     qword [rbp - 24]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 2848],                  rax
     mov                  rdi,   qword [rbp - 2848]
     mov                  rsi,     qword [rbp - 24]
    push     qword [rbp - 24]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 2880],                  rax
     mov                  rdi,   qword [rbp - 2880]
     mov                  rsi,     qword [rbp - 24]
    push     qword [rbp - 24]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 2912],                  rax
     mov                  rdi,   qword [rbp - 2912]
     mov                  rsi,     qword [rbp - 16]
    push     qword [rbp - 16]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 2944],                  rax
     mov                  rdi,   qword [rbp - 2944]
     mov                  rsi,     qword [rbp - 24]
    push     qword [rbp - 24]
    call         _builtin_add
     add                  rsp,                    8
     mov   qword [rbp - 2976],                  rax
     mov                  rdi,   qword [rbp - 2976]
     sub                  rsp,                    8
    call                print
     add                  rsp,                    8
     mov                  rax,                    0
     jmp          main.1.exit
main.1.exit:
     add                  rsp,                 2984
     pop                  rbp
     ret

section	.data
      dq                   20
_string_constant_0:
      db 34, 10, "bda", 92, 34, 10, "dbd", 92, "c", 34, 92, 34, "c", 92, "c", 34, 0
      dq                   20
_string_constant_1:
      db 92, "ab", 10, "ac", 34, 34, "add", 10, 34, 10, "ac", 10, "db", 34, 0
      dq                   20
_string_constant_2:
      db 10, "abbdbdd", 92, 92, 34, "d", 34, "c", 92, "adc", 34, "c", 0

section	.bss


section	.text
_builtin_size:
     mov                  rax,      qword [rdi - 8]
     ret
print:
     mov                  rsi,                  rdi
     mov                  rdi,        _print_format
     sub                  rsp,                    8
    call               printf
     add                  rsp,                    8
     ret
println:
     sub                  rsp,                    8
    call                 puts
     add                  rsp,                    8
     ret
getString:
    push                  r15
     mov                  rdi,                  300
    call               malloc
     mov                  r15,                  rax
     add                  r15,                    8
     mov                  rdi,    _getString_format
     mov                  rsi,                  r15
    call                scanf
     mov                  rdi,                  r15
    call               strlen
     mov      qword [r15 - 8],                  rax
     mov                  rax,                  r15
     pop                  r15
     ret
getInt:
     mov                  rdi,       _getInt_format
     mov                  rsi,        @getIntBuffer
     sub                  rsp,                    8
    call                scanf
     add                  rsp,                    8
     mov                  rax, qword [@getIntBuffer]
     ret
toString:
    push                  r15
    push                  rdi
     mov                  rdi,                   20
     sub                  rsp,                    8
    call               malloc
     add                  rsp,                    8
     mov                  r15,                  rax
     add                  r15,                    8
     mov                  rdi,                  r15
     mov                  rsi,     _toString_format
     pop                  rdx
    call              sprintf
     mov                  rdi,                  r15
    call               strlen
     mov      qword [r15 - 8],                  rax
     mov                  rax,                  r15
     pop                  r15
     ret
_builtin_length:
     mov                  rax,      qword [rdi - 8]
     ret
_builtin_substring:
    push                  r15
     mov                  r15,                  rdi
     add                  r15,                  rsi
    push                  r14
     mov                  r14,                  rdx
     sub                  r14,                  rsi
     add                  r14,                    1
     mov                  rdi,                  r14
     add                  rdi,                    9
     sub                  rsp,                    8
    call               malloc
     add                  rsp,                    8
     add                  rax,                    8
     mov                  rdi,                  rax
     mov                  rsi,                  r15
     mov                  rdx,                  r14
     sub                  rsp,                    8
    call               memcpy
     add                  rsp,                    8
     mov      qword [rax - 8],                  r14
     mov                  r15,                  rax
     add                  r15,                  r14
     mov                  r15,                    0
     pop                  r14
     pop                  r15
     ret
_builtin_parseint:
     mov                  rsi,     _parseInt_format
     mov                  rdx,      @parseIntBuffer
     sub                  rsp,                    8
    call               sscanf
     add                  rsp,                    8
     mov                  rax, qword [@parseIntBuffer]
     ret
_builtin_ord:
     add                  rdi,                  rsi
   movsx                  rax,           byte [rdi]
     ret
_builtin_add:
    push                  r15
    push                  r14
    push                  r13
     mov                  r15,      qword [rdi - 8]
     add                  r15,      qword [rsi - 8]
     add                  r15,                    9
     mov                  r14,                  rdi
     mov                  r13,                  rsi
     mov                  rdi,                  r15
    call               malloc
     sub                  r15,                    9
     mov          qword [rax],                  r15
     mov                  r15,                  rax
     add                  r15,                    8
     mov                  rdi,                  r15
     mov                  rsi,                  r14
    call               strcpy
     add                  r15,      qword [r14 - 8]
     mov                  r14,                  rax
     mov                  rdi,                  r15
     mov                  rsi,                  r13
    call               strcpy
     mov                  rax,                  r14
     pop                  r13
     pop                  r14
     pop                  r15
     ret
_builtin_EQ:
     sub                  rsp,                    8
    call               strcmp
     add                  rsp,                    8
     cmp                  eax,                    0
     mov                  rax,                    0
    sete                   al
     ret
_builtin_GR:
     sub                  rsp,                    8
    call               strcmp
     add                  rsp,                    8
     cmp                  eax,                    0
     mov                  rax,                    0
    setg                   al
     ret
_builtin_GREQ:
     sub                  rsp,                    8
    call               strcmp
     add                  rsp,                    8
     cmp                  eax,                    0
     mov                  rax,                    0
   setge                   al
     ret
_builtin_LE:
     sub                  rsp,                    8
    call               strcmp
     add                  rsp,                    8
     cmp                  eax,                    0
     mov                  rax,                    0
    setl                   al
     ret
_builtin_LEEQ:
     sub                  rsp,                    8
    call               strcmp
     add                  rsp,                    8
     cmp                  eax,                    0
     mov                  rax,                    0
   setle                   al
     ret
_builtin_NEQ:
     sub                  rsp,                    8
    call               strcmp
     add                  rsp,                    8
     cmp                  eax,                    0
     mov                  rax,                    0
   setne                   al
     ret

section	.data
_print_format:
      db              "%s", 0
_getString_format:
      db              "%s", 0
_getInt_format:
      db             "%ld", 0
_toString_format:
      db             "%ld", 0
_parseInt_format:
      db             "%ld", 0

section	.bss
@getIntBuffer:
    resq                    1
@parseIntBuffer:
    resq                    1
