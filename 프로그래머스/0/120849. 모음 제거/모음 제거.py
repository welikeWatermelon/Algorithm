def solution(my_string):
    minus_string = ['a','e','i','o','u']
    return ''.join(i for i in list(my_string) if i not in minus_string)