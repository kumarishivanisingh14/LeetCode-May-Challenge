class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        stack = []
        for ch in num:
            while k > 0 and len(stack) > 0 and int(stack[-1]) > int(ch):
                stack.pop()
                k -= 1
            stack.append(ch)
        
        while k > 0:
            stack.pop()
            k -= 1
        return "0" if len(stack) ==0 else str(int("".join(stack)))
        
        