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
    push                  rbx
main.0.enter:
     mov                  rdi,                   30
    push                  rdi
    call        _builtin_fibo
     pop                  rdi
     mov                  rbx,                  rax
     mov                  rdi,                  rbx
    push                  rdi
    call             toString
     pop                  rdi
     mov                  rbx,                  rax
     mov                  rdi,                  rbx
    push                  rdi
    call              println
     pop                  rdi
     mov                  rax,                    0
     jmp          main.1.exit
main.1.exit:
     pop                  rbx
     pop                  rbp
     ret
fibo:
    push                  rbp
     mov                  rbp,                  rsp
    push                  rbx
fibo.0.enter:
     mov                  rbx,                  rdi
     cmp                  rbx,                    2
     mov                  rsi,                    0
    setl                  sil
     cmp                  rsi,                    1
      je       fibo.1.if_true
     jmp      fibo.2.if_false
fibo.1.if_true:
     mov                  rax,                  rbx
     jmp          fibo.4.exit
fibo.2.if_false:
     jmp       fibo.3.if_exit
fibo.3.if_exit:
     mov                  rsi,                  rbx
     sub                  rsi,                    1
     mov                  rdi,                  rsi
    push                  rdi
    push                  rsi
     sub                  rsp,                    8
    call        _builtin_fibo
     add                  rsp,                    8
     pop                  rsi
     pop                  rdi
     mov                  rsi,                  rax
     sub                  rbx,                    2
     mov                  rdi,                  rbx
    push                  rdi
    push                  rsi
     sub                  rsp,                    8
    call        _builtin_fibo
     add                  rsp,                    8
     pop                  rsi
     pop                  rdi
     mov                  rdi,                  rax
     mov                  rbx,                  rsi
     add                  rbx,                  rdi
     mov                  rax,                  rbx
     jmp          fibo.4.exit
fibo.4.exit:
     pop                  rbx
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
