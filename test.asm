





default rel

global f
global main


SECTION .text   

f:
        push    rbp
        mov     rbp, rsp
        mov     dword [rbp-14H], edi
        mov     dword [rbp-18H], esi
        mov     dword [rbp-1CH], edx
        mov     dword [rbp-20H], ecx
        mov     dword [rbp-24H], r8d
        mov     dword [rbp-28H], r9d
        mov     dword [rbp-4H], 1
        mov     eax, dword [rbp-4H]
        pop     rbp
        ret


main:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16
        push    8
        mov     r9d, 7
        mov     r8d, 6
        mov     ecx, 5
        mov     edx, 4
        mov     esi, 3
        mov     edi, 2
        call    f
        add     rsp, 8
        mov     dword [rbp-4H], eax
        mov     eax, 0
        leave
        ret



SECTION .data   


SECTION .bss    


