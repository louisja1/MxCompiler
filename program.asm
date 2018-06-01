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
     sub                  rsp,                  304
main.0.enter:
    call            getString
     mov     qword [rbp - 16],                  rax
     mov                  rdi,     qword [rbp - 16]
    call    _builtin_parseint
     mov     qword [rbp - 40],                  rax
     mov                  rax,     qword [rbp - 40]
     mov           qword [@n],                  rax
     mov                  rax,           qword [@n]
     mov     qword [rbp - 56],                  rax
     add     qword [rbp - 56],                    1
     sal     qword [rbp - 56],                    3
     mov                  rdi,     qword [rbp - 56]
    call               malloc
     mov     qword [rbp - 64],                  rax
     mov                  rax,           qword [@n]
     mov     qword [rbp - 72],                  rax
     mov                  rcx,     qword [rbp - 64]
     mov                  rax,     qword [rbp - 72]
     mov          qword [rcx],                  rax
     add     qword [rbp - 64],                    8
     mov                  rax,     qword [rbp - 64]
     mov           qword [@a],                  rax
     mov                  rax,                    0
     mov     qword [rbp - 88],                  rax
     jmp main.1.loop_condition
main.1.loop_condition:
     mov                  rdi,           qword [@a]
    call        _builtin_size
     mov    qword [rbp - 112],                  rax
     mov                  rax,     qword [rbp - 88]
     cmp                  rax,    qword [rbp - 112]
     mov                  rax,    qword [rbp - 120]
     mov                  rax,                    0
    setl                   al
     mov    qword [rbp - 120],                  rax
     cmp    qword [rbp - 120],                    1
      je     main.2.loop_body
     jmp     main.4.loop_exit
main.2.loop_body:
     mov                  rax,     qword [rbp - 88]
     mov    qword [rbp - 128],                  rax
     sal    qword [rbp - 128],                    3
     mov                  rax,           qword [@a]
     mov    qword [rbp - 136],                  rax
     mov                  rax,    qword [rbp - 128]
     add    qword [rbp - 136],                  rax
     mov                  rcx,    qword [rbp - 136]
     mov                  rax,     qword [rbp - 88]
     mov          qword [rcx],                  rax
     jmp     main.3.loop_next
main.3.loop_next:
     mov                  rax,     qword [rbp - 88]
     mov    qword [rbp - 144],                  rax
     add    qword [rbp - 144],                    1
     mov                  rax,    qword [rbp - 144]
     mov     qword [rbp - 88],                  rax
     jmp main.1.loop_condition
main.4.loop_exit:
    call             makeHeap
     mov    qword [rbp - 160],                  rax
    call             heapSort
     mov    qword [rbp - 176],                  rax
     mov                  rax,                    0
     mov     qword [rbp - 88],                  rax
     jmp main.5.loop_condition
main.5.loop_condition:
     mov                  rdi,           qword [@a]
    call        _builtin_size
     mov    qword [rbp - 200],                  rax
     mov                  rax,     qword [rbp - 88]
     cmp                  rax,    qword [rbp - 200]
     mov                  rax,    qword [rbp - 208]
     mov                  rax,                    0
    setl                   al
     mov    qword [rbp - 208],                  rax
     cmp    qword [rbp - 208],                    1
      je     main.6.loop_body
     jmp     main.8.loop_exit
main.6.loop_body:
     mov                  rax,     qword [rbp - 88]
     mov    qword [rbp - 216],                  rax
     sal    qword [rbp - 216],                    3
     mov                  rax,           qword [@a]
     mov    qword [rbp - 224],                  rax
     mov                  rax,    qword [rbp - 216]
     add    qword [rbp - 224],                  rax
     mov                  rcx,    qword [rbp - 224]
     mov                  rdi,          qword [rcx]
    call             toString
     mov    qword [rbp - 248],                  rax
     mov                  rdi,    qword [rbp - 248]
     mov                  rsi,   _string_constant_0
     sub                  rsp,                    8
    push   _string_constant_0
    call         _builtin_add
     add                  rsp,                   16
     mov    qword [rbp - 280],                  rax
     mov                  rdi,    qword [rbp - 280]
    call                print
     jmp     main.7.loop_next
main.7.loop_next:
     mov                  rax,     qword [rbp - 88]
     mov    qword [rbp - 296],                  rax
     add    qword [rbp - 296],                39997
     mov                  rax,    qword [rbp - 296]
     mov     qword [rbp - 88],                  rax
     jmp main.5.loop_condition
main.8.loop_exit:
     mov                  rdi,   _string_constant_1
    call                print
     mov                  rax,                    0
     jmp          main.9.exit
main.9.exit:
     add                  rsp,                  304
     pop                  rbp
     ret
exchange:
    push                  rbp
     mov                  rbp,                  rsp
     sub                  rsp,                  104
exchange.0.enter:
     mov                  rax,                  rdi
     mov      qword [rbp - 8],                  rax
     mov                  rax,                  rsi
     mov     qword [rbp - 16],                  rax
     mov                  rax,      qword [rbp - 8]
     mov     qword [rbp - 24],                  rax
     sal     qword [rbp - 24],                    3
     mov                  rax,           qword [@a]
     mov     qword [rbp - 32],                  rax
     mov                  rax,     qword [rbp - 24]
     add     qword [rbp - 32],                  rax
     mov                  rcx,     qword [rbp - 32]
     mov                  rax,          qword [rcx]
     mov     qword [rbp - 48],                  rax
     mov                  rax,      qword [rbp - 8]
     mov     qword [rbp - 56],                  rax
     sal     qword [rbp - 56],                    3
     mov                  rax,           qword [@a]
     mov     qword [rbp - 64],                  rax
     mov                  rax,     qword [rbp - 56]
     add     qword [rbp - 64],                  rax
     mov                  rax,     qword [rbp - 16]
     mov     qword [rbp - 72],                  rax
     sal     qword [rbp - 72],                    3
     mov                  rax,           qword [@a]
     mov     qword [rbp - 80],                  rax
     mov                  rax,     qword [rbp - 72]
     add     qword [rbp - 80],                  rax
     mov                  rcx,     qword [rbp - 80]
     mov                  rax,          qword [rcx]
     mov     qword [rbp - 88],                  rax
     mov                  rcx,     qword [rbp - 64]
     mov                  rax,     qword [rbp - 88]
     mov          qword [rcx],                  rax
     mov                  rax,     qword [rbp - 16]
     mov     qword [rbp - 96],                  rax
     sal     qword [rbp - 96],                    3
     mov                  rax,           qword [@a]
     mov    qword [rbp - 104],                  rax
     mov                  rax,     qword [rbp - 96]
     add    qword [rbp - 104],                  rax
     mov                  rcx,    qword [rbp - 104]
     mov                  rax,     qword [rbp - 48]
     mov          qword [rcx],                  rax
     jmp      exchange.1.exit
exchange.1.exit:
     add                  rsp,                  104
     pop                  rbp
     ret
adjustHeap:
    push                  rbp
     mov                  rbp,                  rsp
     sub                  rsp,                  312
adjustHeap.0.enter:
     mov                  rax,                  rdi
     mov      qword [rbp - 8],                  rax
     mov                  rax,                    0
     mov     qword [rbp - 16],                  rax
     mov                  rax,                    0
     mov     qword [rbp - 24],                  rax
     mov                  rax,                    0
     mov     qword [rbp - 32],                  rax
     jmp adjustHeap.1.loop_condition
adjustHeap.1.loop_condition:
     mov                  rax,     qword [rbp - 16]
     mov     qword [rbp - 40],                  rax
     sal     qword [rbp - 40],                    1
     mov                  rax,     qword [rbp - 40]
     cmp                  rax,      qword [rbp - 8]
     mov                  rax,     qword [rbp - 48]
     mov                  rax,                    0
    setl                   al
     mov     qword [rbp - 48],                  rax
     cmp     qword [rbp - 48],                    1
      je adjustHeap.2.loop_body
     jmp adjustHeap.12.loop_exit
adjustHeap.2.loop_body:
     mov                  rax,     qword [rbp - 16]
     mov     qword [rbp - 56],                  rax
     sal     qword [rbp - 56],                    1
     mov                  rax,     qword [rbp - 56]
     mov     qword [rbp - 24],                  rax
     mov                  rax,     qword [rbp - 16]
     mov     qword [rbp - 64],                  rax
     sal     qword [rbp - 64],                    1
     mov                  rax,     qword [rbp - 64]
     mov     qword [rbp - 72],                  rax
     add     qword [rbp - 72],                    1
     mov                  rax,     qword [rbp - 72]
     cmp                  rax,      qword [rbp - 8]
     mov                  rax,     qword [rbp - 80]
     mov                  rax,                    0
    setl                   al
     mov     qword [rbp - 80],                  rax
     cmp     qword [rbp - 80],                    1
      je adjustHeap.3.logic_true
     jmp adjustHeap.4.logic_false
adjustHeap.3.logic_true:
     mov                  rax,     qword [rbp - 16]
     mov     qword [rbp - 88],                  rax
     sal     qword [rbp - 88],                    1
     mov                  rax,     qword [rbp - 88]
     mov     qword [rbp - 96],                  rax
     add     qword [rbp - 96],                    1
     mov                  rax,     qword [rbp - 96]
     mov    qword [rbp - 104],                  rax
     sal    qword [rbp - 104],                    3
     mov                  rax,           qword [@a]
     mov    qword [rbp - 112],                  rax
     mov                  rax,    qword [rbp - 104]
     add    qword [rbp - 112],                  rax
     mov                  rax,     qword [rbp - 16]
     mov    qword [rbp - 128],                  rax
     sal    qword [rbp - 128],                    1
     mov                  rax,    qword [rbp - 128]
     mov    qword [rbp - 136],                  rax
     sal    qword [rbp - 136],                    3
     mov                  rax,           qword [@a]
     mov    qword [rbp - 144],                  rax
     mov                  rax,    qword [rbp - 136]
     add    qword [rbp - 144],                  rax
     mov                  rcx,    qword [rbp - 112]
     mov                  rax,          qword [rcx]
     mov    qword [rbp - 152],                  rax
     mov                  rcx,    qword [rbp - 144]
     mov                  rax,    qword [rbp - 152]
     cmp                  rax,          qword [rcx]
     mov                  rax,    qword [rbp - 160]
     mov                  rax,                    0
    setl                   al
     mov    qword [rbp - 160],                  rax
     mov                  rax,    qword [rbp - 160]
     mov    qword [rbp - 168],                  rax
     jmp adjustHeap.5.logic_exit
adjustHeap.4.logic_false:
     mov                  rax,                    0
     mov    qword [rbp - 168],                  rax
     jmp adjustHeap.5.logic_exit
adjustHeap.5.logic_exit:
     cmp    qword [rbp - 168],                    1
      je adjustHeap.6.if_true
     jmp adjustHeap.7.if_false
adjustHeap.6.if_true:
     mov                  rax,     qword [rbp - 16]
     mov    qword [rbp - 176],                  rax
     sal    qword [rbp - 176],                    1
     mov                  rax,    qword [rbp - 176]
     mov    qword [rbp - 184],                  rax
     add    qword [rbp - 184],                    1
     mov                  rax,    qword [rbp - 184]
     mov     qword [rbp - 24],                  rax
     jmp adjustHeap.8.if_exit
adjustHeap.7.if_false:
     jmp adjustHeap.8.if_exit
adjustHeap.8.if_exit:
     mov                  rax,     qword [rbp - 16]
     mov    qword [rbp - 192],                  rax
     sal    qword [rbp - 192],                    3
     mov                  rax,           qword [@a]
     mov    qword [rbp - 200],                  rax
     mov                  rax,    qword [rbp - 192]
     add    qword [rbp - 200],                  rax
     mov                  rax,     qword [rbp - 24]
     mov    qword [rbp - 208],                  rax
     sal    qword [rbp - 208],                    3
     mov                  rax,           qword [@a]
     mov    qword [rbp - 216],                  rax
     mov                  rax,    qword [rbp - 208]
     add    qword [rbp - 216],                  rax
     mov                  rcx,    qword [rbp - 200]
     mov                  rax,          qword [rcx]
     mov    qword [rbp - 224],                  rax
     mov                  rcx,    qword [rbp - 216]
     mov                  rax,    qword [rbp - 224]
     cmp                  rax,          qword [rcx]
     mov                  rax,    qword [rbp - 232]
     mov                  rax,                    0
    setg                   al
     mov    qword [rbp - 232],                  rax
     cmp    qword [rbp - 232],                    1
      je adjustHeap.9.if_true
     jmp adjustHeap.10.if_false
adjustHeap.9.if_true:
     mov                  rax,     qword [rbp - 16]
     mov    qword [rbp - 240],                  rax
     sal    qword [rbp - 240],                    3
     mov                  rax,           qword [@a]
     mov    qword [rbp - 248],                  rax
     mov                  rax,    qword [rbp - 240]
     add    qword [rbp - 248],                  rax
     mov                  rcx,    qword [rbp - 248]
     mov                  rax,          qword [rcx]
     mov    qword [rbp - 256],                  rax
     mov                  rax,     qword [rbp - 16]
     mov    qword [rbp - 264],                  rax
     sal    qword [rbp - 264],                    3
     mov                  rax,           qword [@a]
     mov    qword [rbp - 272],                  rax
     mov                  rax,    qword [rbp - 264]
     add    qword [rbp - 272],                  rax
     mov                  rax,     qword [rbp - 24]
     mov    qword [rbp - 280],                  rax
     sal    qword [rbp - 280],                    3
     mov                  rax,           qword [@a]
     mov    qword [rbp - 288],                  rax
     mov                  rax,    qword [rbp - 280]
     add    qword [rbp - 288],                  rax
     mov                  rcx,    qword [rbp - 288]
     mov                  rax,          qword [rcx]
     mov    qword [rbp - 296],                  rax
     mov                  rcx,    qword [rbp - 272]
     mov                  rax,    qword [rbp - 296]
     mov          qword [rcx],                  rax
     mov                  rax,     qword [rbp - 24]
     mov    qword [rbp - 304],                  rax
     sal    qword [rbp - 304],                    3
     mov                  rax,           qword [@a]
     mov    qword [rbp - 312],                  rax
     mov                  rax,    qword [rbp - 304]
     add    qword [rbp - 312],                  rax
     mov                  rcx,    qword [rbp - 312]
     mov                  rax,    qword [rbp - 256]
     mov          qword [rcx],                  rax
     mov                  rax,     qword [rbp - 24]
     mov     qword [rbp - 16],                  rax
     jmp adjustHeap.11.if_exit
adjustHeap.10.if_false:
     jmp adjustHeap.12.loop_exit
adjustHeap.11.if_exit:
     jmp adjustHeap.1.loop_condition
adjustHeap.12.loop_exit:
     mov                  rax,                    0
     jmp   adjustHeap.13.exit
adjustHeap.13.exit:
     add                  rsp,                  312
     pop                  rbp
     ret
heapSort:
    push                  rbp
     mov                  rbp,                  rsp
     sub                  rsp,                  192
heapSort.0.enter:
     mov                  rax,                    0
     mov      qword [rbp - 8],                  rax
     mov                  rax,                    0
     mov     qword [rbp - 16],                  rax
     jmp heapSort.1.loop_condition
heapSort.1.loop_condition:
     mov                  rax,     qword [rbp - 16]
     cmp                  rax,           qword [@n]
     mov                  rax,     qword [rbp - 32]
     mov                  rax,                    0
    setl                   al
     mov     qword [rbp - 32],                  rax
     cmp     qword [rbp - 32],                    1
      je heapSort.2.loop_body
     jmp heapSort.4.loop_exit
heapSort.2.loop_body:
     mov                  rax,                    0
     mov     qword [rbp - 40],                  rax
     sal     qword [rbp - 40],                    3
     mov                  rax,           qword [@a]
     mov     qword [rbp - 48],                  rax
     mov                  rax,     qword [rbp - 40]
     add     qword [rbp - 48],                  rax
     mov                  rcx,     qword [rbp - 48]
     mov                  rax,          qword [rcx]
     mov      qword [rbp - 8],                  rax
     mov                  rax,                    0
     mov     qword [rbp - 64],                  rax
     sal     qword [rbp - 64],                    3
     mov                  rax,           qword [@a]
     mov     qword [rbp - 72],                  rax
     mov                  rax,     qword [rbp - 64]
     add     qword [rbp - 72],                  rax
     mov                  rax,           qword [@n]
     mov     qword [rbp - 80],                  rax
     mov                  rax,     qword [rbp - 16]
     sub     qword [rbp - 80],                  rax
     mov                  rax,     qword [rbp - 80]
     mov     qword [rbp - 88],                  rax
     sub     qword [rbp - 88],                    1
     mov                  rax,     qword [rbp - 88]
     mov     qword [rbp - 96],                  rax
     sal     qword [rbp - 96],                    3
     mov                  rax,           qword [@a]
     mov    qword [rbp - 104],                  rax
     mov                  rax,     qword [rbp - 96]
     add    qword [rbp - 104],                  rax
     mov                  rcx,    qword [rbp - 104]
     mov                  rax,          qword [rcx]
     mov    qword [rbp - 112],                  rax
     mov                  rcx,     qword [rbp - 72]
     mov                  rax,    qword [rbp - 112]
     mov          qword [rcx],                  rax
     mov                  rax,           qword [@n]
     mov    qword [rbp - 120],                  rax
     mov                  rax,     qword [rbp - 16]
     sub    qword [rbp - 120],                  rax
     mov                  rax,    qword [rbp - 120]
     mov    qword [rbp - 128],                  rax
     sub    qword [rbp - 128],                    1
     mov                  rax,    qword [rbp - 128]
     mov    qword [rbp - 136],                  rax
     sal    qword [rbp - 136],                    3
     mov                  rax,           qword [@a]
     mov    qword [rbp - 144],                  rax
     mov                  rax,    qword [rbp - 136]
     add    qword [rbp - 144],                  rax
     mov                  rcx,    qword [rbp - 144]
     mov                  rax,      qword [rbp - 8]
     mov          qword [rcx],                  rax
     mov                  rax,           qword [@n]
     mov    qword [rbp - 152],                  rax
     mov                  rax,     qword [rbp - 16]
     sub    qword [rbp - 152],                  rax
     mov                  rax,    qword [rbp - 152]
     mov    qword [rbp - 160],                  rax
     sub    qword [rbp - 160],                    1
     mov                  rdi,    qword [rbp - 160]
    call           adjustHeap
     mov    qword [rbp - 184],                  rax
     jmp heapSort.3.loop_next
heapSort.3.loop_next:
     mov                  rax,     qword [rbp - 16]
     mov    qword [rbp - 192],                  rax
     add    qword [rbp - 192],                    1
     mov                  rax,    qword [rbp - 192]
     mov     qword [rbp - 16],                  rax
     jmp heapSort.1.loop_condition
heapSort.4.loop_exit:
     mov                  rax,                    0
     jmp      heapSort.5.exit
heapSort.5.exit:
     add                  rsp,                  192
     pop                  rbp
     ret
makeHeap:
    push                  rbp
     mov                  rbp,                  rsp
     sub                  rsp,                  264
makeHeap.0.enter:
     mov                  rax,           qword [@n]
     mov      qword [rbp - 8],                  rax
     sub      qword [rbp - 8],                    1
     mov                  rax,      qword [rbp - 8]
     mov     qword [rbp - 24],                  rax
     sar     qword [rbp - 24],                    1
     mov                  rax,     qword [rbp - 24]
     mov     qword [rbp - 32],                  rax
     mov                  rax,                    0
     mov     qword [rbp - 40],                  rax
     mov                  rax,                    0
     mov     qword [rbp - 48],                  rax
     jmp makeHeap.1.loop_condition
makeHeap.1.loop_condition:
     cmp     qword [rbp - 32],                    0
     mov                  rax,     qword [rbp - 56]
     mov                  rax,                    0
   setge                   al
     mov     qword [rbp - 56],                  rax
     cmp     qword [rbp - 56],                    1
      je makeHeap.2.loop_body
     jmp makeHeap.12.loop_exit
makeHeap.2.loop_body:
     mov                  rax,     qword [rbp - 32]
     mov     qword [rbp - 64],                  rax
     sal     qword [rbp - 64],                    1
     mov                  rax,     qword [rbp - 64]
     mov     qword [rbp - 48],                  rax
     mov                  rax,     qword [rbp - 32]
     mov     qword [rbp - 72],                  rax
     sal     qword [rbp - 72],                    1
     mov                  rax,     qword [rbp - 72]
     mov     qword [rbp - 80],                  rax
     add     qword [rbp - 80],                    1
     mov                  rax,     qword [rbp - 80]
     cmp                  rax,           qword [@n]
     mov                  rax,     qword [rbp - 88]
     mov                  rax,                    0
    setl                   al
     mov     qword [rbp - 88],                  rax
     cmp     qword [rbp - 88],                    1
      je makeHeap.3.logic_true
     jmp makeHeap.4.logic_false
makeHeap.3.logic_true:
     mov                  rax,     qword [rbp - 32]
     mov     qword [rbp - 96],                  rax
     sal     qword [rbp - 96],                    1
     mov                  rax,     qword [rbp - 96]
     mov    qword [rbp - 104],                  rax
     add    qword [rbp - 104],                    1
     mov                  rax,    qword [rbp - 104]
     mov    qword [rbp - 112],                  rax
     sal    qword [rbp - 112],                    3
     mov                  rax,           qword [@a]
     mov    qword [rbp - 120],                  rax
     mov                  rax,    qword [rbp - 112]
     add    qword [rbp - 120],                  rax
     mov                  rax,     qword [rbp - 32]
     mov    qword [rbp - 136],                  rax
     sal    qword [rbp - 136],                    1
     mov                  rax,    qword [rbp - 136]
     mov    qword [rbp - 144],                  rax
     sal    qword [rbp - 144],                    3
     mov                  rax,           qword [@a]
     mov    qword [rbp - 152],                  rax
     mov                  rax,    qword [rbp - 144]
     add    qword [rbp - 152],                  rax
     mov                  rcx,    qword [rbp - 120]
     mov                  rax,          qword [rcx]
     mov    qword [rbp - 160],                  rax
     mov                  rcx,    qword [rbp - 152]
     mov                  rax,    qword [rbp - 160]
     cmp                  rax,          qword [rcx]
     mov                  rax,    qword [rbp - 168]
     mov                  rax,                    0
    setl                   al
     mov    qword [rbp - 168],                  rax
     mov                  rax,    qword [rbp - 168]
     mov    qword [rbp - 176],                  rax
     jmp makeHeap.5.logic_exit
makeHeap.4.logic_false:
     mov                  rax,                    0
     mov    qword [rbp - 176],                  rax
     jmp makeHeap.5.logic_exit
makeHeap.5.logic_exit:
     cmp    qword [rbp - 176],                    1
      je   makeHeap.6.if_true
     jmp  makeHeap.7.if_false
makeHeap.6.if_true:
     mov                  rax,     qword [rbp - 32]
     mov    qword [rbp - 184],                  rax
     sal    qword [rbp - 184],                    1
     mov                  rax,    qword [rbp - 184]
     mov    qword [rbp - 192],                  rax
     add    qword [rbp - 192],                    1
     mov                  rax,    qword [rbp - 192]
     mov     qword [rbp - 48],                  rax
     jmp   makeHeap.8.if_exit
makeHeap.7.if_false:
     jmp   makeHeap.8.if_exit
makeHeap.8.if_exit:
     mov                  rax,     qword [rbp - 32]
     mov    qword [rbp - 200],                  rax
     sal    qword [rbp - 200],                    3
     mov                  rax,           qword [@a]
     mov    qword [rbp - 208],                  rax
     mov                  rax,    qword [rbp - 200]
     add    qword [rbp - 208],                  rax
     mov                  rax,     qword [rbp - 48]
     mov    qword [rbp - 216],                  rax
     sal    qword [rbp - 216],                    3
     mov                  rax,           qword [@a]
     mov    qword [rbp - 224],                  rax
     mov                  rax,    qword [rbp - 216]
     add    qword [rbp - 224],                  rax
     mov                  rcx,    qword [rbp - 208]
     mov                  rax,          qword [rcx]
     mov    qword [rbp - 232],                  rax
     mov                  rcx,    qword [rbp - 224]
     mov                  rax,    qword [rbp - 232]
     cmp                  rax,          qword [rcx]
     mov                  rax,    qword [rbp - 240]
     mov                  rax,                    0
    setg                   al
     mov    qword [rbp - 240],                  rax
     cmp    qword [rbp - 240],                    1
      je   makeHeap.9.if_true
     jmp makeHeap.10.if_false
makeHeap.9.if_true:
     mov                  rdi,     qword [rbp - 32]
     mov                  rsi,     qword [rbp - 48]
    push     qword [rbp - 48]
    call             exchange
     add                  rsp,                    8
     jmp  makeHeap.11.if_exit
makeHeap.10.if_false:
     jmp  makeHeap.11.if_exit
makeHeap.11.if_exit:
     mov                  rax,     qword [rbp - 32]
     mov    qword [rbp - 264],                  rax
     sub    qword [rbp - 264],                    1
     mov                  rax,    qword [rbp - 264]
     mov     qword [rbp - 32],                  rax
     jmp makeHeap.1.loop_condition
makeHeap.12.loop_exit:
     mov                  rax,                    0
     jmp     makeHeap.13.exit
makeHeap.13.exit:
     add                  rsp,                  264
     pop                  rbp
     ret

section	.data
      dq                    1
_string_constant_0:
      db               " ", 0
      dq                    1
_string_constant_1:
      db                10, 0

section	.bss
@a:
    resq                    1
@n:
    resq                    1


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
