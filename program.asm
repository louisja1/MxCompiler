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
     sub                  rsp,                   24
@GlobalDeclaration.0.enter:
     mov                  rax,                    4
     mov      qword [rbp - 8],                  rax
     add      qword [rbp - 8],                    1
     sal      qword [rbp - 8],                    3
     mov                  rax,      qword [rbp - 8]
     mov     qword [rbp - 16],                  rax
     mov                  rcx,     qword [rbp - 16]
     mov                  rax,                    4
     mov          qword [rcx],                  rax
     add     qword [rbp - 16],                    8
     mov                  rax,     qword [rbp - 16]
     mov           qword [@a],                  rax
     jmp @GlobalDeclaration.1.exit
@GlobalDeclaration.1.exit:
     add                  rsp,                   24
     pop                  rbp
     ret
main:
    push                  rbp
     mov                  rbp,                  rsp
    call   @GlobalDeclaration
     sub                  rsp,                   96
main.0.enter:
     mov                  rax,                    4
     mov      qword [rbp - 8],                  rax
     add      qword [rbp - 8],                    1
     sal      qword [rbp - 8],                    3
     mov                  rax,      qword [rbp - 8]
     mov     qword [rbp - 16],                  rax
     mov                  rcx,     qword [rbp - 16]
     mov                  rax,                    4
     mov          qword [rcx],                  rax
     add     qword [rbp - 16],                    8
     mov                  rax,     qword [rbp - 16]
     mov     qword [rbp - 24],                  rax
     mov                  rax,                    2
     mov     qword [rbp - 32],                  rax
     sal     qword [rbp - 32],                    3
     mov                  rax,     qword [rbp - 24]
     mov     qword [rbp - 40],                  rax
     mov                  rax,     qword [rbp - 32]
     add     qword [rbp - 40],                  rax
     mov                  rcx,     qword [rbp - 40]
     mov                  rax,                    2
     mov          qword [rcx],                  rax
     mov                  rax,     qword [rbp - 24]
     mov           qword [@a],                  rax
     mov                  rax,                    2
     mov     qword [rbp - 56],                  rax
     sal     qword [rbp - 56],                    3
     mov                  rax,           qword [@a]
     mov     qword [rbp - 64],                  rax
     mov                  rax,     qword [rbp - 56]
     add     qword [rbp - 64],                  rax
     mov                  rcx,     qword [rbp - 64]
     mov                  rdi,          qword [rcx]
    call             toString
     mov     qword [rbp - 88],                  rax
     mov                  rdi,     qword [rbp - 88]
    call              println
     mov                  rax,                    0
     jmp          main.1.exit
main.1.exit:
     add                  rsp,                   96
     pop                  rbp
     ret

section	.data

section	.bss
@a:
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
