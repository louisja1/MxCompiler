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
     mov                  rbx,                  rdi
     mov                   r8,                  rbx
     mov                  rcx,                  rsi
     sal                   r8,                   cl
     mov                  rdi,                32767
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
shift_l.1.exit:
     pop                  rbx
     pop                  rbp
     ret
getnumber:
    push                  rbp
     mov                  rbp,                  rsp
    push                  rbx
getnumber.0.enter:
     mov                  rbx,                  rdx
     and                  rbx,                   31
    push                  rdi
    push                   r8
    push                  rsi
    call             xorshift
     pop                  rsi
     pop                   r8
     pop                  rdi
     mov                  rsi,                  rax
     mov                  rdi,                  rsi
     mov                  rsi,                  rbx
    push                  rdi
    push                   r8
    push                  rsi
    call              shift_l
     pop                  rsi
     pop                   r8
     pop                  rdi
     mov                   r8,                  rax
     mov                  rsi,                   32
     sub                  rsi,                  rbx
    push                  rdi
    push                   r8
    push                  rsi
    call              shift_r
     pop                  rsi
     pop                   r8
     pop                  rdi
     mov                  rbx,                  rax
     mov                  rsi,                   r8
      or                  rsi,                  rbx
     mov                  rax,                  rsi
getnumber.1.exit:
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
     mov                  rbx,                  rdi
     cmp                  rbx,                   32
     mov                  rsi,                    0
   setge                  sil
     cmp                  rsi,                    1
      je int2chr.1.logic_true
     jmp int2chr.2.logic_false
int2chr.1.logic_true:
     cmp                  rbx,                  126
     mov                  rsi,                    0
   setle                  sil
     jmp int2chr.3.logic_exit
int2chr.2.logic_false:
     mov                  rsi,                    0
int2chr.3.logic_exit:
     cmp                  rsi,                    1
      je    int2chr.4.if_true
     jmp   int2chr.5.if_false
int2chr.4.if_true:
     mov                  rsi,                  rbx
     sub                  rsi,                   32
     sub                  rbx,                   32
     mov                  rdi,  qword [@asciiTable]
     mov                  rdx,                  rbx
    push                  rdi
    push                  rsi
    call   _builtin_substring
     pop                  rsi
     pop                  rdi
     mov                  rbx,                  rax
     mov                  rax,                  rbx
     jmp       int2chr.7.exit
int2chr.5.if_false:
int2chr.6.if_exit:
     mov                  rax,   _string_constant_6
int2chr.7.exit:
     pop                  rbx
     add                  rsp,                    8
     pop                  rbp
     ret
@GlobalDeclaration:
    push                  rbp
     mov                  rbp,                  rsp
     sub                  rsp,                    8
@GlobalDeclaration.0.enter:
     mov  qword [@asciiTable],   _string_constant_7
@GlobalDeclaration.1.exit:
     add                  rsp,                    8
     pop                  rbp
     ret
shift_r:
    push                  rbp
     mov                  rbp,                  rsp
    push                  rbx
shift_r.0.enter:
     mov                   r8,                  rdi
     mov                   r9,                  rsi
     mov                  rdi,                32767
     mov                  rsi,                65535
    push                  r10
    push                   r8
    push                  rdi
    push                   r9
    push                  rsi
    call                 hilo
     pop                  rsi
     pop                   r9
     pop                  rdi
     pop                   r8
     pop                  r10
     mov                  rbx,                  rax
     mov                  r10,                  rbx
     mov                  rbx,                  r10
     mov                  rcx,                   r9
     sar                  rbx,                   cl
     sal                  rbx,                    1
     add                  rbx,                    1
     mov                  r10,                  rbx
     mov                  rsi,                   r8
     mov                  rcx,                   r9
     sar                  rsi,                   cl
     mov                  rbx,                  r10
     and                  rbx,                  rsi
     mov                  r10,                  rbx
     mov                  rdi,                32767
     mov                  rsi,                65535
    push                  r10
    push                   r8
    push                  rdi
    push                   r9
    push                  rsi
    call                 hilo
     pop                  rsi
     pop                   r9
     pop                  rdi
     pop                   r8
     pop                  r10
     mov                  rbx,                  rax
     mov                  rsi,                  r10
     and                  rsi,                  rbx
     mov                  rax,                  rsi
shift_r.1.exit:
     pop                  rbx
     pop                  rbp
     ret
xorshift:
    push                  rbp
     mov                  rbp,                  rsp
    push                  rbx
xorshift.0.enter:
     mov                  rbx,                  rsi
     mov                  rsi,                  rdi
     add                  rsi,                    1
     mov                  rdi,                  rsi
xorshift.1.loop_entry:
     mov                   r8,                    0
xorshift.2.loop_condition:
     mov                  rsi,                  rbx
    imul                  rsi,                   10
     cmp                   r8,                  rsi
     mov                  rsi,                    0
    setl                  sil
     cmp                  rsi,                    1
      je xorshift.3.loop_body
     jmp xorshift.5.loop_exit
xorshift.3.loop_body:
     mov                  rsi,                   13
    push                  rdi
    push                   r8
    push                   r9
    push                  rsi
     sub                  rsp,                    8
    call              shift_l
     add                  rsp,                    8
     pop                  rsi
     pop                   r9
     pop                   r8
     pop                  rdi
     mov                  rsi,                  rax
     xor                  rdi,                  rsi
     mov                  rsi,                   17
    push                  rdi
    push                   r8
    push                   r9
    push                  rsi
     sub                  rsp,                    8
    call              shift_r
     add                  rsp,                    8
     pop                  rsi
     pop                   r9
     pop                   r8
     pop                  rdi
     mov                  rsi,                  rax
     xor                  rdi,                  rsi
     mov                  rsi,                    5
    push                  rdi
    push                   r8
    push                   r9
    push                  rsi
     sub                  rsp,                    8
    call              shift_l
     add                  rsp,                    8
     pop                  rsi
     pop                   r9
     pop                   r8
     pop                  rdi
     mov                   r9,                  rax
     mov                  rsi,                  rdi
     xor                  rsi,                   r9
     mov                  rdi,                  rsi
xorshift.4.loop_next:
     mov                  rsi,                   r8
     add                   r8,                    1
     jmp xorshift.2.loop_condition
xorshift.5.loop_exit:
     mov                  rbx,                  rdi
     xor                  rbx,            123456789
     mov                  rax,                  rbx
xorshift.6.exit:
     pop                  rbx
     pop                  rbp
     ret
main:
    push                  rbp
     mov                  rbp,                  rsp
    call   @GlobalDeclaration
     sub                  rsp,                   96
    push                  rbx
    push                  r12
    push                  r14
    push                  r13
    push                  r15
main.0.enter:
    push                   r8
    push                   r9
    push                  rsi
    push                  r10
    push                  r11
    push                  rdi
     sub                  rsp,                    8
    call               getInt
     add                  rsp,                    8
     pop                  rdi
     pop                  r11
     pop                  r10
     pop                  rsi
     pop                   r9
     pop                   r8
     mov                  rbx,                  rax
     mov      qword [rbp - 8],                  rbx
    push                   r8
    push                   r9
    push                  rsi
    push                  r10
    push                  r11
    push                  rdi
     sub                  rsp,                    8
    call               getInt
     add                  rsp,                    8
     pop                  rdi
     pop                  r11
     pop                  r10
     pop                  rsi
     pop                   r9
     pop                   r8
     mov                  rbx,                  rax
     mov                  r10,                  rbx
    push                   r8
    push                   r9
    push                  rsi
    push                  r10
    push                  r11
    push                  rdi
     sub                  rsp,                    8
    call               getInt
     add                  rsp,                    8
     pop                  rdi
     pop                  r11
     pop                  r10
     pop                  rsi
     pop                   r9
     pop                   r8
     mov                  rbx,                  rax
     mov                   r9,                  rbx
    push                   r8
    push                   r9
    push                  rsi
    push                  r10
    push                  r11
    push                  rdi
     sub                  rsp,                    8
    call               getInt
     add                  rsp,                    8
     pop                  rdi
     pop                  r11
     pop                  r10
     pop                  rsi
     pop                   r9
     pop                   r8
     mov                  rbx,                  rax
     mov                   r8,                  rbx
    push                   r8
    push                   r9
    push                  rsi
    push                  r10
    push                  r11
    push                  rdi
     sub                  rsp,                    8
    call               getInt
     add                  rsp,                    8
     pop                  rdi
     pop                  r11
     pop                  r10
     pop                  rsi
     pop                   r9
     pop                   r8
     mov                  rbx,                  rax
     mov     qword [rbp - 16],                  rbx
    push                   r8
    push                   r9
    push                  rsi
    push                  r10
    push                  r11
    push                  rdi
     sub                  rsp,                    8
    call               getInt
     add                  rsp,                    8
     pop                  rdi
     pop                  r11
     pop                  r10
     pop                  rsi
     pop                   r9
     pop                   r8
     mov                  rbx,                  rax
     mov                  r13,                  rbx
     mov     qword [rbp - 24],                   30
     mov                  r12,                    0
     mov                  r11,                    0
     mov     qword [rbp - 32],                    0
     mov     qword [rbp - 40],                    0
main.1.loop_entry:
     mov                  rax,      qword [rbp - 8]
     mov     qword [rbp - 48],                  rax
main.2.loop_condition:
     cmp     qword [rbp - 48],                  r10
     mov                  rbx,                    0
    setl                   bl
     cmp                  rbx,                    1
      je     main.3.loop_body
     jmp    main.15.loop_exit
main.3.loop_body:
main.4.loop_entry:
     mov                  r14,                   r9
main.5.loop_condition:
     cmp                  r14,                   r8
     mov                  rbx,                    0
    setl                   bl
     cmp                  rbx,                    1
      je     main.6.loop_body
     jmp    main.13.loop_exit
main.6.loop_body:
main.7.loop_entry:
     mov                  rax,     qword [rbp - 16]
     mov     qword [rbp - 56],                  rax
main.8.loop_condition:
     cmp     qword [rbp - 56],                  r13
     mov                  rbx,                    0
    setl                   bl
     cmp                  rbx,                    1
      je     main.9.loop_body
     jmp    main.11.loop_exit
main.9.loop_body:
     mov                  rdi,      qword [rbp - 8]
     mov                  rsi,     qword [rbp - 24]
     mov                  rdx,     qword [rbp - 56]
    push                   r8
    push                   r9
    push                  rsi
    push                  r10
    push                  r11
    push                  rdi
     sub                  rsp,                    8
    call            getnumber
     add                  rsp,                    8
     pop                  rdi
     pop                  r11
     pop                  r10
     pop                  rsi
     pop                   r9
     pop                   r8
     mov                  rbx,                  rax
     mov     qword [rbp - 64],                  rbx
     mov                  rdi,     qword [rbp - 48]
     mov                  rsi,     qword [rbp - 24]
     mov                  rdx,     qword [rbp - 56]
    push                   r8
    push                   r9
    push                  rsi
    push                  r10
    push                  r11
    push                  rdi
     sub                  rsp,                    8
    call            getnumber
     add                  rsp,                    8
     pop                  rdi
     pop                  r11
     pop                  r10
     pop                  rsi
     pop                   r9
     pop                   r8
     mov                  rbx,                  rax
     mov     qword [rbp - 72],                  rbx
     mov                  rdi,                  r14
     mov                  rsi,     qword [rbp - 24]
     mov                  rdx,     qword [rbp - 56]
    push                   r8
    push                   r9
    push                  rsi
    push                  r10
    push                  r11
    push                  rdi
     sub                  rsp,                    8
    call            getnumber
     add                  rsp,                    8
     pop                  rdi
     pop                  r11
     pop                  r10
     pop                  rsi
     pop                   r9
     pop                   r8
     mov                  rbx,                  rax
     mov                  r15,                  rbx
     mov                  rbx,     qword [rbp - 48]
     xor                  rbx,                  r14
     mov                  rdi,                  rbx
     mov                  rsi,     qword [rbp - 24]
     mov                  rdx,     qword [rbp - 56]
    push                   r8
    push                   r9
    push                  rsi
    push                  r10
    push                  r11
    push                  rdi
     sub                  rsp,                    8
    call            getnumber
     add                  rsp,                    8
     pop                  rdi
     pop                  r11
     pop                  r10
     pop                  rsi
     pop                   r9
     pop                   r8
     mov                  rbx,                  rax
     mov     qword [rbp - 80],                  rbx
     mov                  rdi,     qword [rbp - 56]
     mov                  rsi,                    1
    push                   r8
    push                   r9
    push                  rsi
    push                  r10
    push                  r11
    push                  rdi
     sub                  rsp,                    8
    call             xorshift
     add                  rsp,                    8
     pop                  rdi
     pop                  r11
     pop                  r10
     pop                  rsi
     pop                   r9
     pop                   r8
     mov     qword [rbp - 88],                  rax
     mov                  rdi,                  r14
     mov                  rsi,                    1
    push                   r8
    push                   r9
    push                  rsi
    push                  r10
    push                  r11
    push                  rdi
     sub                  rsp,                    8
    call             xorshift
     add                  rsp,                    8
     pop                  rdi
     pop                  r11
     pop                  r10
     pop                  rsi
     pop                   r9
     pop                   r8
     mov                  rbx,                  rax
     mov                  rax,     qword [rbp - 88]
     mov     qword [rbp - 96],                  rax
     xor     qword [rbp - 96],                  rbx
     mov                  rdi,     qword [rbp - 48]
     mov                  rsi,                    1
    push                   r8
    push                   r9
    push                  rsi
    push                  r10
    push                  r11
    push                  rdi
     sub                  rsp,                    8
    call             xorshift
     add                  rsp,                    8
     pop                  rdi
     pop                  r11
     pop                  r10
     pop                  rsi
     pop                   r9
     pop                   r8
     mov                  rsi,                  rax
     mov                  rbx,     qword [rbp - 96]
     xor                  rbx,                  rsi
     mov                  rsi,     qword [rbp - 64]
     xor                  rsi,                  rbx
     mov                  rdi,                  rsi
     mov                  rsi,                    1
    push                   r8
    push                   r9
    push                  rsi
    push                  r10
    push                  r11
    push                  rdi
     sub                  rsp,                    8
    call             xorshift
     add                  rsp,                    8
     pop                  rdi
     pop                  r11
     pop                  r10
     pop                  rsi
     pop                   r9
     pop                   r8
     mov                  rsi,                  rax
     mov                  rdi,                  r12
     add                  rdi,                  rsi
     mov                  r12,                  rdi
     mov                  rsi,     qword [rbp - 72]
     xor                  rsi,                  rbx
     mov                  rdi,                  rsi
     mov                  rsi,                    1
    push                   r8
    push                   r9
    push                  rsi
    push                  r10
    push                  r11
    push                  rdi
     sub                  rsp,                    8
    call             xorshift
     add                  rsp,                    8
     pop                  rdi
     pop                  r11
     pop                  r10
     pop                  rsi
     pop                   r9
     pop                   r8
     mov                  rdi,                  rax
     mov                  rsi,                  r11
     add                  rsi,                  rdi
     mov                  r11,                  rsi
     mov                  rsi,                  r15
     xor                  rsi,                  rbx
     mov                  rdi,                  rsi
     mov                  rsi,                    1
    push                   r8
    push                   r9
    push                  rsi
    push                  r10
    push                  r11
    push                  rdi
     sub                  rsp,                    8
    call             xorshift
     add                  rsp,                    8
     pop                  rdi
     pop                  r11
     pop                  r10
     pop                  rsi
     pop                   r9
     pop                   r8
     mov                  rdi,                  rax
     mov                  rsi,     qword [rbp - 32]
     add                  rsi,                  rdi
     mov     qword [rbp - 32],                  rsi
     mov                  rsi,     qword [rbp - 80]
     xor                  rsi,                  rbx
     mov                  rdi,                  rsi
     mov                  rsi,                    1
    push                   r8
    push                   r9
    push                  rsi
    push                  r10
    push                  r11
    push                  rdi
     sub                  rsp,                    8
    call             xorshift
     add                  rsp,                    8
     pop                  rdi
     pop                  r11
     pop                  r10
     pop                  rsi
     pop                   r9
     pop                   r8
     mov                  rsi,                  rax
     mov                  rbx,     qword [rbp - 40]
     add                  rbx,                  rsi
     mov     qword [rbp - 40],                  rbx
main.10.loop_next:
     mov                  rbx,     qword [rbp - 56]
     add     qword [rbp - 56],                    1
     jmp main.8.loop_condition
main.11.loop_exit:
main.12.loop_next:
     mov                  rbx,                  r14
     add                  r14,                    1
     jmp main.5.loop_condition
main.13.loop_exit:
main.14.loop_next:
     mov                  rbx,     qword [rbp - 48]
     add     qword [rbp - 48],                    1
     jmp main.2.loop_condition
main.15.loop_exit:
     mov                  rdi,                  r12
    push                   r8
    push                   r9
    push                  rsi
    push                  r10
    push                  r11
    push                  rdi
     sub                  rsp,                    8
    call          toStringHex
     add                  rsp,                    8
     pop                  rdi
     pop                  r11
     pop                  r10
     pop                  rsi
     pop                   r9
     pop                   r8
     mov                  rbx,                  rax
     mov                  rdi,                  rbx
     mov                  rsi,   _string_constant_0
    push                   r8
    push                   r9
    push                  rsi
    push                  r10
    push                  r11
    push                  rdi
     sub                  rsp,                    8
    call         _builtin_add
     add                  rsp,                    8
     pop                  rdi
     pop                  r11
     pop                  r10
     pop                  rsi
     pop                   r9
     pop                   r8
     mov                  rbx,                  rax
     mov                  rdi,                  rbx
    push                   r8
    push                   r9
    push                  rsi
    push                  r10
    push                  r11
    push                  rdi
     sub                  rsp,                    8
    call                print
     add                  rsp,                    8
     pop                  rdi
     pop                  r11
     pop                  r10
     pop                  rsi
     pop                   r9
     pop                   r8
     mov                  rdi,                  r11
    push                   r8
    push                   r9
    push                  rsi
    push                  r10
    push                  r11
    push                  rdi
     sub                  rsp,                    8
    call          toStringHex
     add                  rsp,                    8
     pop                  rdi
     pop                  r11
     pop                  r10
     pop                  rsi
     pop                   r9
     pop                   r8
     mov                  rbx,                  rax
     mov                  rdi,                  rbx
     mov                  rsi,   _string_constant_1
    push                   r8
    push                   r9
    push                  rsi
    push                  r10
    push                  r11
    push                  rdi
     sub                  rsp,                    8
    call         _builtin_add
     add                  rsp,                    8
     pop                  rdi
     pop                  r11
     pop                  r10
     pop                  rsi
     pop                   r9
     pop                   r8
     mov                  rbx,                  rax
     mov                  rdi,                  rbx
    push                   r8
    push                   r9
    push                  rsi
    push                  r10
    push                  r11
    push                  rdi
     sub                  rsp,                    8
    call                print
     add                  rsp,                    8
     pop                  rdi
     pop                  r11
     pop                  r10
     pop                  rsi
     pop                   r9
     pop                   r8
     mov                  rdi,     qword [rbp - 32]
    push                   r8
    push                   r9
    push                  rsi
    push                  r10
    push                  r11
    push                  rdi
     sub                  rsp,                    8
    call          toStringHex
     add                  rsp,                    8
     pop                  rdi
     pop                  r11
     pop                  r10
     pop                  rsi
     pop                   r9
     pop                   r8
     mov                  rbx,                  rax
     mov                  rdi,                  rbx
     mov                  rsi,   _string_constant_2
    push                   r8
    push                   r9
    push                  rsi
    push                  r10
    push                  r11
    push                  rdi
     sub                  rsp,                    8
    call         _builtin_add
     add                  rsp,                    8
     pop                  rdi
     pop                  r11
     pop                  r10
     pop                  rsi
     pop                   r9
     pop                   r8
     mov                  rbx,                  rax
     mov                  rdi,                  rbx
    push                   r8
    push                   r9
    push                  rsi
    push                  r10
    push                  r11
    push                  rdi
     sub                  rsp,                    8
    call                print
     add                  rsp,                    8
     pop                  rdi
     pop                  r11
     pop                  r10
     pop                  rsi
     pop                   r9
     pop                   r8
     mov                  rdi,     qword [rbp - 40]
    push                   r8
    push                   r9
    push                  rsi
    push                  r10
    push                  r11
    push                  rdi
     sub                  rsp,                    8
    call          toStringHex
     add                  rsp,                    8
     pop                  rdi
     pop                  r11
     pop                  r10
     pop                  rsi
     pop                   r9
     pop                   r8
     mov                  rbx,                  rax
     mov                  rdi,                  rbx
     mov                  rsi,   _string_constant_3
    push                   r8
    push                   r9
    push                  rsi
    push                  r10
    push                  r11
    push                  rdi
     sub                  rsp,                    8
    call         _builtin_add
     add                  rsp,                    8
     pop                  rdi
     pop                  r11
     pop                  r10
     pop                  rsi
     pop                   r9
     pop                   r8
     mov                  rbx,                  rax
     mov                  rdi,                  rbx
    push                   r8
    push                   r9
    push                  rsi
    push                  r10
    push                  r11
    push                  rdi
     sub                  rsp,                    8
    call                print
     add                  rsp,                    8
     pop                  rdi
     pop                  r11
     pop                  r10
     pop                  rsi
     pop                   r9
     pop                   r8
     mov                  rdi,   _string_constant_4
    push                   r8
    push                   r9
    push                  rsi
    push                  r10
    push                  r11
    push                  rdi
     sub                  rsp,                    8
    call              println
     add                  rsp,                    8
     pop                  rdi
     pop                  r11
     pop                  r10
     pop                  rsi
     pop                   r9
     pop                   r8
     mov                  rax,                    0
main.16.exit:
     pop                  r15
     pop                  r13
     pop                  r14
     pop                  r12
     pop                  rbx
     add                  rsp,                   96
     pop                  rbp
     ret
toStringHex:
    push                  rbp
     mov                  rbp,                  rsp
    push                  rbx
toStringHex.0.enter:
     mov                   r8,                  rdi
     mov                  rsi,   _string_constant_5
toStringHex.1.loop_entry:
     mov                  rbx,                   28
toStringHex.2.loop_condition:
     cmp                  rbx,                    0
     mov                  rdi,                    0
   setge                  dil
     cmp                  rdi,                    1
      je toStringHex.3.loop_body
     jmp toStringHex.8.loop_exit
toStringHex.3.loop_body:
     mov                  rdi,                   r8
     mov                  rcx,                  rbx
     sar                  rdi,                   cl
     and                  rdi,                   15
     mov                   r9,                  rdi
     cmp                   r9,                   10
     mov                  rdi,                    0
    setl                  dil
     cmp                  rdi,                    1
      je toStringHex.4.if_true
     jmp toStringHex.5.if_false
toStringHex.4.if_true:
     mov                  rdi,                   48
     add                  rdi,                   r9
    push                   r8
    push                  rdi
    push                   r9
    push                  rsi
     sub                  rsp,                    8
    call              int2chr
     add                  rsp,                    8
     pop                  rsi
     pop                   r9
     pop                  rdi
     pop                   r8
     mov                   r9,                  rax
     mov                  rdi,                  rsi
     mov                  rsi,                   r9
    push                   r8
    push                  rdi
    push                   r9
    push                  rsi
     sub                  rsp,                    8
    call         _builtin_add
     add                  rsp,                    8
     pop                  rsi
     pop                   r9
     pop                  rdi
     pop                   r8
     mov                  rsi,                  rax
     jmp toStringHex.6.if_exit
toStringHex.5.if_false:
     mov                  rdi,                   65
     add                  rdi,                   r9
     sub                  rdi,                   10
    push                   r8
    push                  rdi
    push                   r9
    push                  rsi
     sub                  rsp,                    8
    call              int2chr
     add                  rsp,                    8
     pop                  rsi
     pop                   r9
     pop                  rdi
     pop                   r8
     mov                   r9,                  rax
     mov                  rdi,                  rsi
     mov                  rsi,                   r9
    push                   r8
    push                  rdi
    push                   r9
    push                  rsi
     sub                  rsp,                    8
    call         _builtin_add
     add                  rsp,                    8
     pop                  rsi
     pop                   r9
     pop                  rdi
     pop                   r8
     mov                  rsi,                  rax
toStringHex.6.if_exit:
toStringHex.7.loop_next:
     sub                  rbx,                    4
     jmp toStringHex.2.loop_condition
toStringHex.8.loop_exit:
     mov                  rax,                  rsi
toStringHex.9.exit:
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
      dq                    0
_string_constant_5:
      db                    0
      dq                    0
_string_constant_6:
      db                    0
      dq                   95
_string_constant_7:
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
_builtin_fibo:
    push                  r15
    push                  r14
    push                  r13
    push                  r12
_builtin_fibo_init:
     cmp                  rdi,                    2
     jge   _builtin_fibo_work
     mov                  rax,                  rdi
     jmp   _builtin_fibo_exit
_builtin_fibo_work:
     mov                  r13,                    2
     mov                  r14,                    1
     mov                  r15,                    1
_builtin_fibo_cmp:
     cmp                  r13,                  rdi
      je    _builtin_fibo_ans
     mov                  r12,                  r15
     add                  r12,                  r14
     mov                  r14,                  r15
     mov                  r15,                  r12
     add                  r13,                    1
     jmp    _builtin_fibo_cmp
_builtin_fibo_ans:
     mov                  rax,                  r15
     jmp   _builtin_fibo_exit
_builtin_fibo_exit:
     pop                  r12
     pop                  r13
     pop                  r14
     pop                  r15
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
