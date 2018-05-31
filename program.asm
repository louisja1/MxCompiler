  global                 main
   exter               printf
   exter               malloc
   exter               strcpy
   exter                scanf
   exter               strlen
   exter               sscanf
   exter              sprintf
   exter               memcpy
   exter               strcmp
   exter                 puts

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
     sub                  rsp,                  128
main.0.enter:
     mov                  rax,                    5
     mov      qword [rbp - 8],                  rax
     mov                  rax,                    0
     mov     qword [rbp - 16],                  rax
     cmp     qword [rbp - 16],                    0
     mov                  rax,     qword [rbp - 24]
     mov                  rax,                    0
   setne                   al
     mov     qword [rbp - 24],                  rax
     cmp     qword [rbp - 24],                    1
      je    main.1.logic_true
     jmp   main.2.logic_false
main.1.logic_true:
     mov                  rax,      qword [rbp - 8]
     mov     qword [rbp - 32],                  rax
     mov                  rax,     qword [rbp - 32]
     mov                  rcx,     qword [rbp - 16]
     cdq
    idiv                  ecx
     mov     qword [rbp - 32],                  rax
     cmp     qword [rbp - 32],                    1
     mov                  rax,     qword [rbp - 40]
     mov                  rax,                    0
   setne                   al
     mov     qword [rbp - 40],                  rax
     mov                  rax,     qword [rbp - 40]
     mov     qword [rbp - 48],                  rax
     jmp    main.3.logic_exit
main.2.logic_false:
     mov                  rax,                    0
     mov     qword [rbp - 48],                  rax
     jmp    main.3.logic_exit
main.3.logic_exit:
     mov                  rax,     qword [rbp - 48]
     mov     qword [rbp - 56],                  rax
     cmp     qword [rbp - 56],                    1
      je       main.4.if_true
     jmp      main.5.if_false
main.4.if_true:
     mov                  rax,                   10
     mov     qword [rbp - 64],                  rax
     jmp       main.6.if_exit
main.5.if_false:
     mov                  rax,                   20
     mov     qword [rbp - 64],                  rax
     jmp       main.6.if_exit
main.6.if_exit:
     cmp     qword [rbp - 64],                   10
     mov                  rax,     qword [rbp - 72]
     mov                  rax,                    0
    sete                   al
     mov     qword [rbp - 72],                  rax
     cmp     qword [rbp - 72],                    1
      je    main.7.logic_true
     jmp   main.8.logic_false
main.7.logic_true:
     mov                  rax,      qword [rbp - 8]
     mov     qword [rbp - 80],                  rax
     mov                  rax,     qword [rbp - 80]
     mov                  rcx,     qword [rbp - 16]
     cdq
    idiv                  ecx
     mov     qword [rbp - 80],                  rax
     cmp     qword [rbp - 80],                    0
     mov                  rax,     qword [rbp - 88]
     mov                  rax,                    0
    sete                   al
     mov     qword [rbp - 88],                  rax
     mov                  rax,     qword [rbp - 88]
     mov     qword [rbp - 96],                  rax
     jmp    main.9.logic_exit
main.8.logic_false:
     mov                  rax,                    0
     mov     qword [rbp - 96],                  rax
     jmp    main.9.logic_exit
main.9.logic_exit:
     cmp     qword [rbp - 96],                    1
      je   main.10.logic_true
     jmp  main.11.logic_false
main.10.logic_true:
     cmp      qword [rbp - 8],                    5
     mov                  rax,    qword [rbp - 104]
     mov                  rax,                    0
    sete                   al
     mov    qword [rbp - 104],                  rax
     mov                  rax,    qword [rbp - 104]
     mov    qword [rbp - 112],                  rax
     jmp   main.12.logic_exit
main.11.logic_false:
     mov                  rax,                    0
     mov    qword [rbp - 112],                  rax
     jmp   main.12.logic_exit
main.12.logic_exit:
     mov                  rax,    qword [rbp - 112]
     mov    qword [rbp - 120],                  rax
     cmp    qword [rbp - 120],                    1
     mov                  rax,    qword [rbp - 120]
     mov                  rax,                    0
   setne                   al
     mov    qword [rbp - 120],                  rax
     mov                  rax,    qword [rbp - 120]
     mov    qword [rbp - 128],                  rax
     cmp    qword [rbp - 128],                    1
      je      main.13.if_true
     jmp     main.14.if_false
main.13.if_true:
     mov                  rax,                   30
     mov     qword [rbp - 64],                  rax
     jmp      main.15.if_exit
main.14.if_false:
     jmp      main.15.if_exit
main.15.if_exit:
     mov                  rax,     qword [rbp - 64]
     jmp         main.16.exit
main.16.exit:
     add                  rsp,                  128
     pop                  rbp
     ret

section	.data

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
     pop                  rxi
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
     mov          qword [r15],                    0
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
     mov                  r15,      qword [rdi - 8]
     add                  r15,      qword [rsi - 8]
     add                  r15,                    9
    push                  r14
     mov                  r14,                  rdi
    push                  r13
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
     add                  r15,      qword [r13 - 8]
     mov          qword [r15],                    0
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
