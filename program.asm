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
shift_l:
    push                  rbp
     mov                  rbp,                  rsp
    push                  rbx
shift_l.0.enter:
     mov                  rbx,                  rsi
     mov                   r8,                  rdi
     mov                  rcx,                  rbx
     sal                   r8,                   cl
     mov                  rdi,                65535
     mov                  rsi,                65535
    push                  rdi
    push                   r8
    push                  rsi
    call                 hilo
     pop                  rsi
     pop                   r8
     pop                  rdi
     mov                  rbx,                  rax
     mov                  rsi,                   r8
     and                  rsi,                  rbx
     mov                  rax,                  rsi
     jmp       shift_l.1.exit
shift_l.1.exit:
     pop                  rbx
     pop                  rbp
     ret
hilo:
    push                  rbp
     mov                  rbp,                  rsp
    push                  rbx
hilo.0.enter:
     mov                  rbx,                  rdi
     sal                  rbx,                   16
      or                  rsi,                  rbx
     mov                  rax,                  rsi
     jmp          hilo.1.exit
hilo.1.exit:
     pop                  rbx
     pop                  rbp
     ret
int2chr:
    push                  rbp
     mov                  rbp,                  rsp
     sub                  rsp,                    8
    push                  rbx
int2chr.0.enter:
     mov                  rsi,                  rdi
     cmp                  rsi,                   32
     mov                  rbx,                    0
   setge                   bl
     cmp                  rbx,                    1
      je int2chr.1.logic_true
     jmp int2chr.2.logic_false
int2chr.1.logic_true:
     cmp                  rsi,                  126
     mov                  rbx,                    0
   setle                   bl
     jmp int2chr.3.logic_exit
int2chr.2.logic_false:
     mov                  rbx,                    0
     jmp int2chr.3.logic_exit
int2chr.3.logic_exit:
     cmp                  rbx,                    1
      je    int2chr.4.if_true
     jmp   int2chr.5.if_false
int2chr.4.if_true:
     mov                  rbx,                  rsi
     sub                  rbx,                   32
     mov                   r8,                  rsi
     sub                   r8,                   32
     mov                  rdi,  qword [@asciiTable]
     mov                  rsi,                  rbx
     mov                  rdx,                   r8
    push                  rdi
    push                   r8
    push                  rsi
     sub                  rsp,                    8
    call   _builtin_substring
     add                  rsp,                    8
     pop                  rsi
     pop                   r8
     pop                  rdi
     mov                  rbx,                  rax
     mov                  rax,                  rbx
     jmp       int2chr.7.exit
int2chr.5.if_false:
     jmp    int2chr.6.if_exit
int2chr.6.if_exit:
     mov                  rax,   _string_constant_7
     jmp       int2chr.7.exit
int2chr.7.exit:
     pop                  rbx
     add                  rsp,                    8
     pop                  rbp
     ret
assert:
    push                  rbp
     mov                  rbp,                  rsp
    push                  rbx
assert.0.enter:
     mov                  rbx,                  rdi
     cmp                  rbx,                    1
     mov                  rbx,                    0
   setne                   bl
     cmp                  rbx,                    1
      je     assert.1.if_true
     jmp    assert.2.if_false
assert.1.if_true:
     mov                  rdi,   _string_constant_5
    push                  rdi
    call              println
     pop                  rdi
     jmp     assert.3.if_exit
assert.2.if_false:
     jmp     assert.3.if_exit
assert.3.if_exit:
     jmp        assert.4.exit
assert.4.exit:
     pop                  rbx
     pop                  rbp
     ret
@GlobalDeclaration:
    push                  rbp
     mov                  rbp,                  rsp
     sub                  rsp,                    8
@GlobalDeclaration.0.enter:
     mov  qword [@asciiTable],   _string_constant_8
     jmp @GlobalDeclaration.1.exit
@GlobalDeclaration.1.exit:
     add                  rsp,                    8
     pop                  rbp
     ret
shift_r:
    push                  rbp
     mov                  rbp,                  rsp
    push                  rbx
shift_r.0.enter:
     mov                   r9,                  rdi
     mov                   r8,                  rsi
     mov                  rdi,                32767
     mov                  rsi,                65535
    push                  rdi
    push                   r8
    push                   r9
    push                  rsi
     sub                  rsp,                    8
    call                 hilo
     add                  rsp,                    8
     pop                  rsi
     pop                   r9
     pop                   r8
     pop                  rdi
     mov                  rbx,                  rax
     mov                  rcx,                   r8
     sar                  rbx,                   cl
     sal                  rbx,                    1
     add                  rbx,                    1
     mov                  rsi,                   r9
     mov                  rcx,                   r8
     sar                  rsi,                   cl
     and                  rbx,                  rsi
     mov                  rdi,                65535
     mov                  rsi,                65535
    push                  rdi
    push                   r8
    push                   r9
    push                  rsi
     sub                  rsp,                    8
    call                 hilo
     add                  rsp,                    8
     pop                  rsi
     pop                   r9
     pop                   r8
     pop                  rdi
     mov                  rsi,                  rax
     and                  rbx,                  rsi
     mov                  rax,                  rbx
     jmp       shift_r.1.exit
shift_r.1.exit:
     pop                  rbx
     pop                  rbp
     ret
xorshift:
    push                  rbp
     mov                  rbp,                  rsp
    push                  rbx
xorshift.0.enter:
     mov                  rbx,                  rdi
     mov                  rdi,                  rbx
     mov                  rsi,                   13
    push                  rdi
    push                  rsi
     sub                  rsp,                    8
    call              shift_l
     add                  rsp,                    8
     pop                  rsi
     pop                  rdi
     mov                  rbx,                  rax
     mov                  rsi,                  rdi
     xor                  rsi,                  rbx
     mov                  rdi,                  rsi
     mov                  rsi,                   17
    push                  rdi
    push                  rsi
     sub                  rsp,                    8
    call              shift_r
     add                  rsp,                    8
     pop                  rsi
     pop                  rdi
     mov                  rsi,                  rax
     mov                  rbx,                  rdi
     xor                  rbx,                  rsi
     mov                  rdi,                  rbx
     mov                  rsi,                    5
    push                  rdi
    push                  rsi
     sub                  rsp,                    8
    call              shift_l
     add                  rsp,                    8
     pop                  rsi
     pop                  rdi
     mov                  rsi,                  rax
     mov                  rbx,                  rdi
     xor                  rbx,                  rsi
     mov                  rdi,                  rbx
     mov                  rax,                  rdi
     jmp      xorshift.1.exit
xorshift.1.exit:
     pop                  rbx
     pop                  rbp
     ret
main:
    push                  rbp
     mov                  rbp,                  rsp
    call   @GlobalDeclaration
     sub                  rsp,                   88
    push                  r12
    push                  r14
    push                  r13
    push                  r15
    push                  rbx
main.0.enter:
    push                  r10
    push                  r11
    push                  rdi
    push                   r8
    push                   r9
    push                  rsi
    call               getInt
     pop                  rsi
     pop                   r9
     pop                   r8
     pop                  rdi
     pop                  r11
     pop                  r10
     mov                  rbx,                  rax
     mov                  r11,                  rbx
    push                  r10
    push                  r11
    push                  rdi
    push                   r8
    push                   r9
    push                  rsi
    call               getInt
     pop                  rsi
     pop                   r9
     pop                   r8
     pop                  rdi
     pop                  r11
     pop                  r10
     mov                  rbx,                  rax
    push                  r10
    push                  r11
    push                  rdi
    push                   r8
    push                   r9
    push                  rsi
    call               getInt
     pop                  rsi
     pop                   r9
     pop                   r8
     pop                  rdi
     pop                  r11
     pop                  r10
     mov                  rsi,                  rax
     mov                  r12,                  rsi
    push                  r10
    push                  r11
    push                  rdi
    push                   r8
    push                   r9
    push                  rsi
    call               getInt
     pop                  rsi
     pop                   r9
     pop                   r8
     pop                  rdi
     pop                  r11
     pop                  r10
     mov                  rsi,                  rax
     mov                  r13,                  rsi
     mov                  rsi,                  r11
     add                  rsi,                    1
     mov                  rdi,                  rsi
    push                  r10
    push                  r11
    push                  rdi
    push                   r8
    push                   r9
    push                  rsi
    call           xorshift10
     pop                  rsi
     pop                   r9
     pop                   r8
     pop                  rdi
     pop                  r11
     pop                  r10
     mov                  rsi,                  rax
     mov                  r11,                  rsi
     mov                  rdi,                32767
     mov                  rsi,                65535
    push                  r10
    push                  r11
    push                  rdi
    push                   r8
    push                   r9
    push                  rsi
    call                 hilo
     pop                  rsi
     pop                   r9
     pop                   r8
     pop                  rdi
     pop                  r11
     pop                  r10
     mov                  rsi,                  rax
     mov                  r14,                  rsi
     mov      qword [rbp - 8],                    0
     mov                   r9,                    0
     mov     qword [rbp - 16],                    0
     mov     qword [rbp - 24],                    0
     mov                  rsi,                    0
     mov     qword [rbp - 32],                  rbx
     jmp main.1.loop_condition
main.1.loop_condition:
     cmp     qword [rbp - 32],                  r12
     mov                  rbx,                    0
    setl                   bl
     cmp                  rbx,                    1
      je     main.2.loop_body
     jmp    main.13.loop_exit
main.2.loop_body:
     mov                  rdi,                  r11
    push                  r10
    push                  r11
    push                  rdi
    push                   r8
    push                   r9
    push                  rsi
    call             xorshift
     pop                  rsi
     pop                   r9
     pop                   r8
     pop                  rdi
     pop                  r11
     pop                  r10
     mov                  rbx,                  rax
     mov                  r11,                  rbx
     mov                  rbx,                  r11
     and                  rbx,                  r14
     mov     qword [rbp - 40],                  rbx
     mov                  rdi,                  r11
    push                  r10
    push                  r11
    push                  rdi
    push                   r8
    push                   r9
    push                  rsi
    call             xorshift
     pop                  rsi
     pop                   r9
     pop                   r8
     pop                  rdi
     pop                  r11
     pop                  r10
     mov                  rbx,                  rax
     mov                  r11,                  rbx
     mov                  rbx,                  r11
     and                  rbx,                  r14
     mov     qword [rbp - 48],                  rbx
     mov                  rdi,                  r11
    push                  r10
    push                  r11
    push                  rdi
    push                   r8
    push                   r9
    push                  rsi
    call             xorshift
     pop                  rsi
     pop                   r9
     pop                   r8
     pop                  rdi
     pop                  r11
     pop                  r10
     mov                  rbx,                  rax
     mov                  r11,                  rbx
     mov                  rbx,                  r11
     and                  rbx,                  r14
     mov     qword [rbp - 56],                  rbx
     mov                  rdi,                  r11
    push                  r10
    push                  r11
    push                  rdi
    push                   r8
    push                   r9
    push                  rsi
    call             xorshift
     pop                  rsi
     pop                   r9
     pop                   r8
     pop                  rdi
     pop                  r11
     pop                  r10
     mov                  rbx,                  rax
     mov                  r11,                  rbx
     mov                  rbx,                  r11
     and                  rbx,                  r14
     mov     qword [rbp - 64],                  rbx
     mov                  rdi,                  r11
    push                  r10
    push                  r11
    push                  rdi
    push                   r8
    push                   r9
    push                  rsi
    call             xorshift
     pop                  rsi
     pop                   r9
     pop                   r8
     pop                  rdi
     pop                  r11
     pop                  r10
     mov                  rbx,                  rax
     mov                  r11,                  rbx
     mov                  rbx,                  r11
     and                  rbx,                  r14
     mov     qword [rbp - 72],                  rbx
     mov                  rdi,                  r11
    push                  r10
    push                  r11
    push                  rdi
    push                   r8
    push                   r9
    push                  rsi
    call             xorshift
     pop                  rsi
     pop                   r9
     pop                   r8
     pop                  rdi
     pop                  r11
     pop                  r10
     mov                  rbx,                  rax
     mov                  r11,                  rbx
     mov                  rbx,                  r11
     and                  rbx,                  r14
     mov                  r10,                  rbx
     mov                  rbx,     qword [rbp - 40]
     xor                  rbx,     qword [rbp - 48]
     xor                  rbx,     qword [rbp - 56]
     mov                   r8,                  rbx
     mov                  rbx,     qword [rbp - 64]
     xor                  rbx,     qword [rbp - 72]
     mov                  rsi,                  rbx
     xor                  rsi,                  r10
     mov                  rbx,                   r8
     xor                  rbx,                  rsi
     mov                   r8,                  rbx
     mov                  rbx,                   r8
     and                  rbx,                  r14
     mov                   r8,                  rbx
     mov                  rbx,     qword [rbp - 40]
     add                  rbx,     qword [rbp - 48]
     add                  rbx,     qword [rbp - 56]
     add                  rbx,                    1
     mov                  rsi,                  rbx
     mov                  rbx,     qword [rbp - 64]
     add                  rbx,     qword [rbp - 72]
     mov                  rdi,                  rbx
     add                  rdi,                  r10
     mov                  rbx,                  rsi
     sub                  rbx,                  rdi
     mov                  rsi,                  rbx
     mov                  rbx,                  rsi
     and                  rbx,                  r14
     mov                  rsi,                  rbx
     mov                  rdi,     qword [rbp - 40]
     mov                  rax,                  rdi
     mov                  rcx,                  r13
     cdq
    idiv                  ecx
     mov                  rdi,                  rdx
     mov                  rbx,     qword [rbp - 48]
     mov                  rax,                  rbx
     mov                  rcx,                  r13
     cdq
    idiv                  ecx
     mov                  rbx,                  rdx
    imul                  rdi,                  rbx
     mov                  rbx,     qword [rbp - 56]
     mov                  rax,                  rbx
     mov                  rcx,                  r13
     cdq
    idiv                  ecx
     mov                  rbx,                  rdx
    imul                  rdi,                  rbx
     mov     qword [rbp - 80],                  rdi
     mov                  rbx,     qword [rbp - 64]
     mov                  rax,                  rbx
     mov                  rcx,                  r13
     cdq
    idiv                  ecx
     mov                  rbx,                  rdx
     mov                  rdi,     qword [rbp - 80]
    imul                  rdi,                  rbx
     mov                  rbx,     qword [rbp - 72]
     mov                  rax,                  rbx
     mov                  rcx,                  r13
     cdq
    idiv                  ecx
     mov                  rbx,                  rdx
    imul                  rdi,                  rbx
     mov                  r15,                  r10
     mov                  rax,                  r15
     mov                  rcx,                  r13
     cdq
    idiv                  ecx
     mov                  r15,                  rdx
     mov                  rbx,                  rdi
    imul                  rbx,                  r15
     mov     qword [rbp - 80],                  rbx
     mov                  rbx,     qword [rbp - 80]
     and                  rbx,                  r14
     mov     qword [rbp - 80],                  rbx
     mov                  rbx,     qword [rbp - 40]
     xor                  rbx,     qword [rbp - 48]
     mov                  rdi,                  rbx
     xor                  rdi,     qword [rbp - 56]
     mov                  rbx,     qword [rbp - 64]
     xor                  rbx,     qword [rbp - 72]
     xor                  rbx,                  r10
     cmp                  rdi,                  rbx
     mov                  rbx,                    0
    setg                   bl
     cmp                  rbx,                    1
      je       main.3.if_true
     jmp      main.4.if_false
main.3.if_true:
     mov                  rbx,     qword [rbp - 40]
     add                  rbx,     qword [rbp - 48]
     and                  rbx,                  r14
     mov                  rdi,                  rbx
     mov                  rax,                  rdi
     mov                  rcx,                  r13
     cdq
    idiv                  ecx
     mov                  rdi,                  rdx
     mov                  rbx,     qword [rbp - 56]
     mov                  rax,                  rbx
     mov                  rcx,                  r13
     cdq
    idiv                  ecx
     mov                  rbx,                  rdx
     add                  rbx,                    1
     mov                  rax,                  rdi
     mov                  rcx,                  rbx
     cdq
    idiv                  ecx
     mov                  rdi,                  rdx
     mov                  r15,                  rdi
     jmp       main.5.if_exit
main.4.if_false:
     mov                  rbx,     qword [rbp - 56]
     add                  rbx,     qword [rbp - 48]
     and                  rbx,                  r14
     mov                  rdi,                  rbx
     mov                  rax,                  rdi
     mov                  rcx,                  r13
     cdq
    idiv                  ecx
     mov                  rdi,                  rdx
     mov                  rbx,     qword [rbp - 40]
     mov                  rax,                  rbx
     mov                  rcx,                  r13
     cdq
    idiv                  ecx
     mov                  rbx,                  rdx
     add                  rbx,                    1
     mov                  rax,                  rdi
     mov                  rcx,                  rbx
     cdq
    idiv                  ecx
     mov                  rdi,                  rdx
     mov                  r15,                  rdi
     jmp       main.5.if_exit
main.5.if_exit:
     mov                  rbx,                   r8
     xor                  rbx,                10001
     mov                  rdi,                  rbx
    push                  r10
    push                  r11
    push                  rdi
    push                   r8
    push                   r9
    push                  rsi
    call           xorshift10
     pop                  rsi
     pop                   r9
     pop                   r8
     pop                  rdi
     pop                  r11
     pop                  r10
     mov                  rdi,                  rax
     mov                  rbx,      qword [rbp - 8]
     add                  rbx,                  rdi
     mov      qword [rbp - 8],                  rbx
     mov                  rbx,                  rsi
     xor                  rbx,                10002
     mov                  rdi,                  rbx
    push                  r10
    push                  r11
    push                  rdi
    push                   r8
    push                   r9
    push                  rsi
    call           xorshift10
     pop                  rsi
     pop                   r9
     pop                   r8
     pop                  rdi
     pop                  r11
     pop                  r10
     mov                  rsi,                  rax
     mov                  rbx,                   r9
     add                  rbx,                  rsi
     mov                   r9,                  rbx
     mov                  rbx,     qword [rbp - 80]
     xor                  rbx,                10003
     mov                  rdi,                  rbx
    push                  r10
    push                  r11
    push                  rdi
    push                   r8
    push                   r9
    push                  rsi
    call           xorshift10
     pop                  rsi
     pop                   r9
     pop                   r8
     pop                  rdi
     pop                  r11
     pop                  r10
     mov                  rsi,                  rax
     mov                  rbx,     qword [rbp - 16]
     add                  rbx,                  rsi
     mov     qword [rbp - 16],                  rbx
     mov                  rbx,                  r15
     xor                  rbx,                10004
     mov                  rdi,                  rbx
    push                  r10
    push                  r11
    push                  rdi
    push                   r8
    push                   r9
    push                  rsi
    call           xorshift10
     pop                  rsi
     pop                   r9
     pop                   r8
     pop                  rdi
     pop                  r11
     pop                  r10
     mov                  rbx,                  rax
     mov                  rsi,     qword [rbp - 24]
     add                  rsi,                  rbx
     mov     qword [rbp - 24],                  rsi
     mov                  rbx,     qword [rbp - 64]
     xor                  rbx,     qword [rbp - 48]
     xor                  rbx,     qword [rbp - 56]
     mov                  r15,                  rbx
     mov                  rbx,                  r15
     xor                  rbx,     qword [rbp - 40]
     xor                  rbx,                  r10
     xor                  rbx,     qword [rbp - 72]
     mov                  r15,                  rbx
     mov                  rbx,                  r15
     and                  rbx,                  r14
     mov                  r15,                  rbx
     mov                  rbx,     qword [rbp - 64]
     neg                  rbx
     add                  rbx,     qword [rbp - 48]
     add                  rbx,     qword [rbp - 56]
     mov     qword [rbp - 88],                  rbx
     mov                  rbx,     qword [rbp - 88]
     add                  rbx,     qword [rbp - 40]
     sub                  rbx,                  r10
     sub                  rbx,     qword [rbp - 72]
     add                  rbx,                    1
     mov     qword [rbp - 88],                  rbx
     mov                  rbx,     qword [rbp - 88]
     and                  rbx,                  r14
     mov     qword [rbp - 88],                  rbx
     mov                  rbx,     qword [rbp - 64]
     mov                  rax,                  rbx
     mov                  rcx,                  r13
     cdq
    idiv                  ecx
     mov                  rbx,                  rdx
     mov                  rsi,     qword [rbp - 48]
     mov                  rax,                  rsi
     mov                  rcx,                  r13
     cdq
    idiv                  ecx
     mov                  rsi,                  rdx
    imul                  rbx,                  rsi
     mov                  rsi,     qword [rbp - 56]
     mov                  rax,                  rsi
     mov                  rcx,                  r13
     cdq
    idiv                  ecx
     mov                  rsi,                  rdx
    imul                  rbx,                  rsi
     mov                  rsi,                  rbx
     mov                  rdi,     qword [rbp - 40]
     mov                  rax,                  rdi
     mov                  rcx,                  r13
     cdq
    idiv                  ecx
     mov                  rdi,                  rdx
     mov                  rbx,                  rsi
    imul                  rbx,                  rdi
     mov                  rsi,                  r10
     mov                  rax,                  rsi
     mov                  rcx,                  r13
     cdq
    idiv                  ecx
     mov                  rsi,                  rdx
    imul                  rbx,                  rsi
     mov                  rsi,     qword [rbp - 72]
     mov                  rax,                  rsi
     mov                  rcx,                  r13
     cdq
    idiv                  ecx
     mov                  rsi,                  rdx
    imul                  rbx,                  rsi
     mov                  rsi,                  rbx
     mov                  rbx,                  rsi
     and                  rbx,                  r14
     mov                  rsi,                  rbx
     mov                  rbx,     qword [rbp - 40]
     xor                  rbx,     qword [rbp - 48]
     xor                  rbx,     qword [rbp - 56]
     mov                  rdi,     qword [rbp - 64]
     xor                  rdi,     qword [rbp - 72]
     xor                  rdi,                  r10
     cmp                  rbx,                  rdi
     mov                  rbx,                    0
   setle                   bl
     cmp                  rbx,                    1
      je       main.6.if_true
     jmp      main.7.if_false
main.6.if_true:
     mov                  rbx,     qword [rbp - 56]
     add                  rbx,     qword [rbp - 48]
     and                  rbx,                  r14
     mov                  rdi,                  rbx
     mov                  rax,                  rdi
     mov                  rcx,                  r13
     cdq
    idiv                  ecx
     mov                  rdi,                  rdx
     mov                  rbx,     qword [rbp - 40]
     mov                  rax,                  rbx
     mov                  rcx,                  r13
     cdq
    idiv                  ecx
     mov                  rbx,                  rdx
     mov                   r8,                  rbx
     add                   r8,                    1
     mov                  rbx,                  rdi
     mov                  rax,                  rbx
     mov                  rcx,                   r8
     cdq
    idiv                  ecx
     mov                  rbx,                  rdx
     mov                   r8,                  rbx
     jmp       main.8.if_exit
main.7.if_false:
     mov                  rbx,     qword [rbp - 40]
     add                  rbx,     qword [rbp - 48]
     and                  rbx,                  r14
     mov                  rdi,                  rbx
     mov                  rax,                  rdi
     mov                  rcx,                  r13
     cdq
    idiv                  ecx
     mov                  rdi,                  rdx
     mov                  rbx,     qword [rbp - 56]
     mov                  rax,                  rbx
     mov                  rcx,                  r13
     cdq
    idiv                  ecx
     mov                  rbx,                  rdx
     mov                   r8,                  rbx
     add                   r8,                    1
     mov                  rbx,                  rdi
     mov                  rax,                  rbx
     mov                  rcx,                   r8
     cdq
    idiv                  ecx
     mov                  rbx,                  rdx
     mov                   r8,                  rbx
     jmp       main.8.if_exit
main.8.if_exit:
     mov                  rbx,                  r15
     xor                  rbx,                10001
     mov                  rdi,                  rbx
    push                  r10
    push                  r11
    push                  rdi
    push                   r8
    push                   r9
    push                  rsi
    call           xorshift10
     pop                  rsi
     pop                   r9
     pop                   r8
     pop                  rdi
     pop                  r11
     pop                  r10
     mov                  rdi,                  rax
     mov                  rbx,      qword [rbp - 8]
     add                  rbx,                  rdi
     mov      qword [rbp - 8],                  rbx
     mov                  rbx,     qword [rbp - 88]
     xor                  rbx,                10002
     mov                  rdi,                  rbx
    push                  r10
    push                  r11
    push                  rdi
    push                   r8
    push                   r9
    push                  rsi
    call           xorshift10
     pop                  rsi
     pop                   r9
     pop                   r8
     pop                  rdi
     pop                  r11
     pop                  r10
     mov                  rbx,                  rax
     mov                  rdi,                   r9
     add                  rdi,                  rbx
     mov                   r9,                  rdi
     mov                  rbx,                  rsi
     xor                  rbx,                10003
     mov                  rdi,                  rbx
    push                  r10
    push                  r11
    push                  rdi
    push                   r8
    push                   r9
    push                  rsi
    call           xorshift10
     pop                  rsi
     pop                   r9
     pop                   r8
     pop                  rdi
     pop                  r11
     pop                  r10
     mov                  rbx,                  rax
     mov                  rsi,     qword [rbp - 16]
     add                  rsi,                  rbx
     mov     qword [rbp - 16],                  rsi
     mov                  rbx,                   r8
     xor                  rbx,                10004
     mov                  rdi,                  rbx
    push                  r10
    push                  r11
    push                  rdi
    push                   r8
    push                   r9
    push                  rsi
    call           xorshift10
     pop                  rsi
     pop                   r9
     pop                   r8
     pop                  rdi
     pop                  r11
     pop                  r10
     mov                  rbx,                  rax
     mov                  rsi,     qword [rbp - 24]
     add                  rsi,                  rbx
     mov     qword [rbp - 24],                  rsi
     mov                  rbx,     qword [rbp - 64]
     xor                  rbx,     qword [rbp - 40]
     xor                  rbx,     qword [rbp - 56]
     xor                  rbx,     qword [rbp - 48]
     xor                  rbx,                  r10
     xor                  rbx,     qword [rbp - 72]
     and                  rbx,                  r14
     mov                  rsi,     qword [rbp - 64]
     sub                  rsi,     qword [rbp - 48]
     mov                  rdi,     qword [rbp - 56]
     neg                  rdi
     add                  rsi,                  rdi
     mov                  r15,                  rsi
     mov                  rsi,                  r15
     sub                  rsi,     qword [rbp - 40]
     add                  rsi,                  r10
     add                  rsi,     qword [rbp - 72]
     sub                  rsi,                    1
     mov                  r15,                  rsi
     mov                  rsi,                  r15
     neg                  rsi
     and                  rsi,                  r14
     mov                  r15,                  rsi
     mov                  rdi,     qword [rbp - 64]
     mov                  rax,                  rdi
     mov                  rcx,                  r13
     cdq
    idiv                  ecx
     mov                  rdi,                  rdx
     mov                  rsi,     qword [rbp - 72]
     mov                  rax,                  rsi
     mov                  rcx,                  r13
     cdq
    idiv                  ecx
     mov                  rsi,                  rdx
    imul                  rdi,                  rsi
     mov                   r8,                  r10
     mov                  rax,                   r8
     mov                  rcx,                  r13
     cdq
    idiv                  ecx
     mov                   r8,                  rdx
     mov                  rsi,                  rdi
    imul                  rsi,                   r8
     mov                   r8,                  rsi
     mov                  rsi,     qword [rbp - 40]
     mov                  rax,                  rsi
     mov                  rcx,                  r13
     cdq
    idiv                  ecx
     mov                  rsi,                  rdx
     mov                  rdi,                   r8
    imul                  rdi,                  rsi
     mov                  rsi,     qword [rbp - 48]
     mov                  rax,                  rsi
     mov                  rcx,                  r13
     cdq
    idiv                  ecx
     mov                  rsi,                  rdx
    imul                  rdi,                  rsi
     mov                  rsi,     qword [rbp - 56]
     mov                  rax,                  rsi
     mov                  rcx,                  r13
     cdq
    idiv                  ecx
     mov                  rsi,                  rdx
    imul                  rdi,                  rsi
     mov                   r8,                  rdi
     mov                  rsi,                   r8
     and                  rsi,                  r14
     mov                   r8,                  rsi
     mov                  rsi,     qword [rbp - 64]
     xor                  rsi,     qword [rbp - 72]
     mov                  rdi,                  rsi
     xor                  rdi,                  r10
     mov                  rsi,     qword [rbp - 56]
     xor                  rsi,     qword [rbp - 48]
     xor                  rsi,     qword [rbp - 40]
     cmp                  rdi,                  rsi
     mov                  rsi,                    0
    setl                  sil
     cmp                  rsi,                    1
      je       main.9.if_true
     jmp     main.10.if_false
main.9.if_true:
     mov                  rsi,     qword [rbp - 40]
     add                  rsi,     qword [rbp - 48]
     and                  rsi,                  r14
     mov                  rax,                  rsi
     mov                  rcx,                  r13
     cdq
    idiv                  ecx
     mov                  rsi,                  rdx
     mov                  rdi,     qword [rbp - 56]
     mov                  rax,                  rdi
     mov                  rcx,                  r13
     cdq
    idiv                  ecx
     mov                  rdi,                  rdx
     add                  rdi,                    1
     mov                  rax,                  rsi
     mov                  rcx,                  rdi
     cdq
    idiv                  ecx
     mov                  rsi,                  rdx
     jmp      main.11.if_exit
main.10.if_false:
     mov                  rsi,     qword [rbp - 56]
     add                  rsi,     qword [rbp - 48]
     and                  rsi,                  r14
     mov                  r10,                  rsi
     mov                  rax,                  r10
     mov                  rcx,                  r13
     cdq
    idiv                  ecx
     mov                  r10,                  rdx
     mov                  rsi,     qword [rbp - 40]
     mov                  rax,                  rsi
     mov                  rcx,                  r13
     cdq
    idiv                  ecx
     mov                  rsi,                  rdx
     mov                  rdi,                  rsi
     add                  rdi,                    1
     mov                  rsi,                  r10
     mov                  rax,                  rsi
     mov                  rcx,                  rdi
     cdq
    idiv                  ecx
     mov                  rsi,                  rdx
     jmp      main.11.if_exit
main.11.if_exit:
     xor                  rbx,                10001
     mov                  rdi,                  rbx
    push                  r10
    push                  r11
    push                  rdi
    push                   r8
    push                   r9
    push                  rsi
    call           xorshift10
     pop                  rsi
     pop                   r9
     pop                   r8
     pop                  rdi
     pop                  r11
     pop                  r10
     mov                  rdi,                  rax
     mov                  rbx,      qword [rbp - 8]
     add                  rbx,                  rdi
     mov      qword [rbp - 8],                  rbx
     mov                  rbx,                  r15
     xor                  rbx,                10002
     mov                  rdi,                  rbx
    push                  r10
    push                  r11
    push                  rdi
    push                   r8
    push                   r9
    push                  rsi
    call           xorshift10
     pop                  rsi
     pop                   r9
     pop                   r8
     pop                  rdi
     pop                  r11
     pop                  r10
     mov                  rdi,                  rax
     mov                  rbx,                   r9
     add                  rbx,                  rdi
     mov                   r9,                  rbx
     mov                  rbx,                   r8
     xor                  rbx,                10003
     mov                  rdi,                  rbx
    push                  r10
    push                  r11
    push                  rdi
    push                   r8
    push                   r9
    push                  rsi
    call           xorshift10
     pop                  rsi
     pop                   r9
     pop                   r8
     pop                  rdi
     pop                  r11
     pop                  r10
     mov                  rbx,                  rax
     mov                  rdi,     qword [rbp - 16]
     add                  rdi,                  rbx
     mov     qword [rbp - 16],                  rdi
     mov                  rbx,                  rsi
     xor                  rbx,                10004
     mov                  rdi,                  rbx
    push                  r10
    push                  r11
    push                  rdi
    push                   r8
    push                   r9
    push                  rsi
    call           xorshift10
     pop                  rsi
     pop                   r9
     pop                   r8
     pop                  rdi
     pop                  r11
     pop                  r10
     mov                  rbx,                  rax
     mov                  rsi,     qword [rbp - 24]
     add                  rsi,                  rbx
     mov     qword [rbp - 24],                  rsi
     jmp    main.12.loop_next
main.12.loop_next:
     mov                  rbx,     qword [rbp - 32]
     add     qword [rbp - 32],                    1
     jmp main.1.loop_condition
main.13.loop_exit:
     mov                  rdi,      qword [rbp - 8]
    push                  r10
    push                  r11
    push                  rdi
    push                   r8
    push                   r9
    push                  rsi
    call          toStringHex
     pop                  rsi
     pop                   r9
     pop                   r8
     pop                  rdi
     pop                  r11
     pop                  r10
     mov                  rbx,                  rax
     mov                  rdi,                  rbx
     mov                  rsi,   _string_constant_0
    push                  r10
    push                  r11
    push                  rdi
    push                   r8
    push                   r9
    push                  rsi
    call         _builtin_add
     pop                  rsi
     pop                   r9
     pop                   r8
     pop                  rdi
     pop                  r11
     pop                  r10
     mov                  rbx,                  rax
     mov                  rdi,                  rbx
    push                  r10
    push                  r11
    push                  rdi
    push                   r8
    push                   r9
    push                  rsi
    call                print
     pop                  rsi
     pop                   r9
     pop                   r8
     pop                  rdi
     pop                  r11
     pop                  r10
     mov                  rdi,                   r9
    push                  r10
    push                  r11
    push                  rdi
    push                   r8
    push                   r9
    push                  rsi
    call          toStringHex
     pop                  rsi
     pop                   r9
     pop                   r8
     pop                  rdi
     pop                  r11
     pop                  r10
     mov                  rbx,                  rax
     mov                  rdi,                  rbx
     mov                  rsi,   _string_constant_1
    push                  r10
    push                  r11
    push                  rdi
    push                   r8
    push                   r9
    push                  rsi
    call         _builtin_add
     pop                  rsi
     pop                   r9
     pop                   r8
     pop                  rdi
     pop                  r11
     pop                  r10
     mov                  rbx,                  rax
     mov                  rdi,                  rbx
    push                  r10
    push                  r11
    push                  rdi
    push                   r8
    push                   r9
    push                  rsi
    call                print
     pop                  rsi
     pop                   r9
     pop                   r8
     pop                  rdi
     pop                  r11
     pop                  r10
     mov                  rdi,     qword [rbp - 16]
    push                  r10
    push                  r11
    push                  rdi
    push                   r8
    push                   r9
    push                  rsi
    call          toStringHex
     pop                  rsi
     pop                   r9
     pop                   r8
     pop                  rdi
     pop                  r11
     pop                  r10
     mov                  rbx,                  rax
     mov                  rdi,                  rbx
     mov                  rsi,   _string_constant_2
    push                  r10
    push                  r11
    push                  rdi
    push                   r8
    push                   r9
    push                  rsi
    call         _builtin_add
     pop                  rsi
     pop                   r9
     pop                   r8
     pop                  rdi
     pop                  r11
     pop                  r10
     mov                  rbx,                  rax
     mov                  rdi,                  rbx
    push                  r10
    push                  r11
    push                  rdi
    push                   r8
    push                   r9
    push                  rsi
    call                print
     pop                  rsi
     pop                   r9
     pop                   r8
     pop                  rdi
     pop                  r11
     pop                  r10
     mov                  rdi,     qword [rbp - 24]
    push                  r10
    push                  r11
    push                  rdi
    push                   r8
    push                   r9
    push                  rsi
    call          toStringHex
     pop                  rsi
     pop                   r9
     pop                   r8
     pop                  rdi
     pop                  r11
     pop                  r10
     mov                  rbx,                  rax
     mov                  rdi,                  rbx
     mov                  rsi,   _string_constant_3
    push                  r10
    push                  r11
    push                  rdi
    push                   r8
    push                   r9
    push                  rsi
    call         _builtin_add
     pop                  rsi
     pop                   r9
     pop                   r8
     pop                  rdi
     pop                  r11
     pop                  r10
     mov                  rbx,                  rax
     mov                  rdi,                  rbx
    push                  r10
    push                  r11
    push                  rdi
    push                   r8
    push                   r9
    push                  rsi
    call                print
     pop                  rsi
     pop                   r9
     pop                   r8
     pop                  rdi
     pop                  r11
     pop                  r10
     mov                  rdi,   _string_constant_4
    push                  r10
    push                  r11
    push                  rdi
    push                   r8
    push                   r9
    push                  rsi
    call              println
     pop                  rsi
     pop                   r9
     pop                   r8
     pop                  rdi
     pop                  r11
     pop                  r10
     mov                  rax,                    0
     jmp         main.14.exit
main.14.exit:
     pop                  rbx
     pop                  r15
     pop                  r13
     pop                  r14
     pop                  r12
     add                  rsp,                   88
     pop                  rbp
     ret
xorshift10:
    push                  rbp
     mov                  rbp,                  rsp
    push                  rbx
xorshift10.0.enter:
     mov                  rbx,                  rdi
     mov                  rdi,                  rbx
    push                  rdi
    call             xorshift
     pop                  rdi
     mov                  rbx,                  rax
     mov                  rdi,                  rbx
    push                  rdi
    call             xorshift
     pop                  rdi
     mov                  rbx,                  rax
     mov                  rdi,                  rbx
    push                  rdi
    call             xorshift
     pop                  rdi
     mov                  rbx,                  rax
     mov                  rdi,                  rbx
    push                  rdi
    call             xorshift
     pop                  rdi
     mov                  rbx,                  rax
     mov                  rdi,                  rbx
    push                  rdi
    call             xorshift
     pop                  rdi
     mov                  rbx,                  rax
     mov                  rdi,                  rbx
    push                  rdi
    call             xorshift
     pop                  rdi
     mov                  rbx,                  rax
     mov                  rdi,                  rbx
    push                  rdi
    call             xorshift
     pop                  rdi
     mov                  rbx,                  rax
     mov                  rdi,                  rbx
    push                  rdi
    call             xorshift
     pop                  rdi
     mov                  rbx,                  rax
     mov                  rdi,                  rbx
    push                  rdi
    call             xorshift
     pop                  rdi
     mov                  rbx,                  rax
     mov                  rdi,                  rbx
    push                  rdi
    call             xorshift
     pop                  rdi
     mov                  rbx,                  rax
     mov                  rax,                  rbx
     jmp    xorshift10.1.exit
xorshift10.1.exit:
     pop                  rbx
     pop                  rbp
     ret
toStringHex:
    push                  rbp
     mov                  rbp,                  rsp
    push                  rbx
toStringHex.0.enter:
     mov                  rbx,                  rdi
     mov                  rsi,   _string_constant_6
     mov                   r8,                   28
     jmp toStringHex.1.loop_condition
toStringHex.1.loop_condition:
     cmp                   r8,                    0
     mov                  rdi,                    0
   setge                  dil
     cmp                  rdi,                    1
      je toStringHex.2.loop_body
     jmp toStringHex.7.loop_exit
toStringHex.2.loop_body:
     mov                  rdi,                  rbx
     mov                  rcx,                   r8
     sar                  rdi,                   cl
     and                  rdi,                   15
     cmp                  rdi,                   10
     mov                   r9,                    0
    setl                  r9b
     cmp                   r9,                    1
      je toStringHex.3.if_true
     jmp toStringHex.4.if_false
toStringHex.3.if_true:
     mov                   r9,                   48
     add                   r9,                  rdi
     mov                  rdi,                   r9
    push                  rdi
    push                   r8
    push                   r9
    push                  rsi
     sub                  rsp,                    8
    call              int2chr
     add                  rsp,                    8
     pop                  rsi
     pop                   r9
     pop                   r8
     pop                  rdi
     mov                   r9,                  rax
     mov                  rdi,                  rsi
     mov                  rsi,                   r9
    push                  rdi
    push                   r8
    push                   r9
    push                  rsi
     sub                  rsp,                    8
    call         _builtin_add
     add                  rsp,                    8
     pop                  rsi
     pop                   r9
     pop                   r8
     pop                  rdi
     mov                  rsi,                  rax
     jmp toStringHex.5.if_exit
toStringHex.4.if_false:
     mov                   r9,                   65
     add                   r9,                  rdi
     mov                  rdi,                   r9
     sub                  rdi,                   10
    push                  rdi
    push                   r8
    push                   r9
    push                  rsi
     sub                  rsp,                    8
    call              int2chr
     add                  rsp,                    8
     pop                  rsi
     pop                   r9
     pop                   r8
     pop                  rdi
     mov                   r9,                  rax
     mov                  rdi,                  rsi
     mov                  rsi,                   r9
    push                  rdi
    push                   r8
    push                   r9
    push                  rsi
     sub                  rsp,                    8
    call         _builtin_add
     add                  rsp,                    8
     pop                  rsi
     pop                   r9
     pop                   r8
     pop                  rdi
     mov                  rsi,                  rax
     jmp toStringHex.5.if_exit
toStringHex.5.if_exit:
     jmp toStringHex.6.loop_next
toStringHex.6.loop_next:
     mov                  rdi,                   r8
     sub                  rdi,                    4
     mov                   r8,                  rdi
     jmp toStringHex.1.loop_condition
toStringHex.7.loop_exit:
     mov                  rax,                  rsi
     jmp   toStringHex.8.exit
toStringHex.8.exit:
     pop                  rbx
     pop                  rbp
     ret

section	.data
      dq                    1
_string_constant_0:
      db               " ", 0
      dq                    1
_string_constant_1:
      db               " ", 0
      dq                    1
_string_constant_2:
      db               " ", 0
      dq                    1
_string_constant_3:
      db               " ", 0
      dq                    0
_string_constant_4:
      db                    0
      dq                   17
_string_constant_5:
      db "Assertion Failed!", 0
      dq                    0
_string_constant_6:
      db                    0
      dq                    0
_string_constant_7:
      db                    0
      dq                   95
_string_constant_8:
      db " !", 34, "#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[", 92, "]^_`abcdefghijklmnopqrstuvwxyz{|}~", 0

section	.bss
@asciiTable:
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
