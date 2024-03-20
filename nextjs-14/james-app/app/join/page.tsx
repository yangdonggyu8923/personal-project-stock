'use client';

import { useState } from "react";


const SERVER = 'http://localhost:8080'
export default function Join(){
    
    const [username, setUsername] = useState('')
    const [password, setPassword] = useState('')
    const [checkPassword, setCheckPassword] = useState('')

    const handleChangeId = (e:any)=>{setUsername(e.target.value)}
    const handleChangePw = (e:any)=>{setPassword(e.target.value)}
    const handleChangeCpw = (e:any)=>{setCheckPassword(e.target.value)}
    const handleClick = () => {
        alert('ID = '+ username + 'PW = ' +password+'CPW = '+checkPassword)
        const url = `${SERVER}/login`
        const data = { username: username, password: password } // '' 생략가능, {username, password}로 생략가능
        const config = {
            headers: {
                "Cache-Control": "no-cache",
                "Content-Type": "application/json",
                Authorization: `Bearer blah ~`,
                "Access-Control-Allow-Origin": "*",
            }
        }}
    
    return(<>
    <h2>회원가입</h2>
    <h3>ID</h3>
    <input type="text" onChange={handleChangeId}/>
    <h3>비밀번호</h3>
    <input type="text" onChange={handleChangePw}/>
    <h3>비밀번호 확인</h3>
    <input type="text" onChange={handleChangeCpw} /><br /><br />
    <button onClick={handleClick}>회원가입</button>

    </>
    );
}