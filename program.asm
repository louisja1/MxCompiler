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
     sub                  rsp,                   40
main.0.enter:
     mov                  rdi,                   18
     mov                  rsi,                   12
     mov                  rdx,                    6
    push                    6
    call                  tak
     add                  rsp,                    8
     mov     qword [rbp - 40],                  rax
     mov                  rax,     qword [rbp - 40]
     jmp          main.1.exit
main.1.exit:
     add                  rsp,                   40
     pop                  rbp
     ret
tak:
    push                  rbp
     mov                  rbp,                  rsp
     sub                  rsp,                  224
tak.0.enter:
     mov                  rax,                  rdi
     mov      qword [rbp - 8],                  rax
     mov                  rax,                  rsi
     mov     qword [rbp - 16],                  rax
     mov                  rax,                  rdx
     mov     qword [rbp - 24],                  rax
     mov                  rax,     qword [rbp - 16]
     cmp                  rax,      qword [rbp - 8]
     mov                  rax,     qword [rbp - 32]
     mov                  rax,                    0
    setl                   al
     mov     qword [rbp - 32],                  rax
     cmp     qword [rbp - 32],                    1
      je        tak.1.if_true
     jmp       tak.2.if_false
tak.1.if_true:
     mov                  rax,      qword [rbp - 8]
     mov     qword [rbp - 40],                  rax
     sub     qword [rbp - 40],                    1
     mov                  rdi,     qword [rbp - 40]
     mov                  rsi,     qword [rbp - 16]
     mov                  rdx,     qword [rbp - 24]
    push                  rdi
    push                  rsi
     sub                  rsp,                    8
    push     qword [rbp - 24]
    call                  tak
     add                  rsp,                   16
     pop                  rsi
     pop                  rdi
     mov     qword [rbp - 80],                  rax
     mov                  rax,     qword [rbp - 16]
     mov     qword [rbp - 88],                  rax
     sub     qword [rbp - 88],                    1
     mov                  rdi,     qword [rbp - 88]
     mov                  rsi,     qword [rbp - 24]
     mov                  rdx,      qword [rbp - 8]
    push                  rdi
    push                  rsi
     sub                  rsp,                    8
    push      qword [rbp - 8]
    call                  tak
     add                  rsp,                   16
     pop                  rsi
     pop                  rdi
     mov    qword [rbp - 128],                  rax
     mov                  rax,     qword [rbp - 24]
     mov    qword [rbp - 136],                  rax
     sub    qword [rbp - 136],                    1
     mov                  rdi,    qword [rbp - 136]
     mov                  rsi,      qword [rbp - 8]
     mov                  rdx,     qword [rbp - 16]
    push                  rdi
    push                  rsi
     sub                  rsp,                    8
    push     qword [rbp - 16]
    call                  tak
     add                  rsp,                   16
     pop                  rsi
     pop                  rdi
     mov    qword [rbp - 176],                  rax
     mov                  rdi,     qword [rbp - 80]
     mov                  rsi,    qword [rbp - 128]
     mov                  rdx,    qword [rbp - 176]
    push                  rdi
    push                  rsi
     sub                  rsp,                    8
    push    qword [rbp - 176]
    call                  tak
     add                  rsp,                   16
     pop                  rsi
     pop                  rdi
     mov    qword [rbp - 216],                  rax
     mov                  rax,                    1
     mov    qword [rbp - 224],                  rax
     mov                  rax,    qword [rbp - 216]
     add    qword [rbp - 224],                  rax
     mov                  rax,    qword [rbp - 224]
     jmp           tak.4.exit
tak.2.if_false:
     mov                  rax,     qword [rbp - 24]
     jmp           tak.4.exit
tak.3.if_exit:
     jmp           tak.4.exit
tak.4.exit:
     add                  rsp,                  224
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
