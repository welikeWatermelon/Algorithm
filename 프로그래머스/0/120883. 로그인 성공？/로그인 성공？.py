def solution(id_pw, db):
    if id_pw in db:
        return "login"
    else:
        for i in db:
            if i[0]==id_pw[0]:
                return "wrong pw"
        return "fail"