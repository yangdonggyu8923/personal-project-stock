'use client';
import axios from "axios";
import Link from "next/link";
import { useState } from "react";


const SERVER = 'http://localhost:8080'
export default function Login() {

    const [username, setUsername] = useState('')
    const [password, setPassword] = useState('')
    const handleChangePw = (e: any) => { setPassword(e.target.value) }
    const handleChange = (e: any) => { setUsername(e.target.value) }
    const handleSubmit = () => {
        alert('입력한 ID = ' + username)
        const url = `${SERVER}/login`
        const data = { username: username, password: password } // '' 생략가능, {username, password}로 생략가능
        const config = {
            headers: {
                "Cache-Control": "no-cache",
                "Content-Type": "application/json",
                Authorization: `Bearer blah ~`,
                "Access-Control-Allow-Origin": "*",
            }
        }
        axios.post(url, data, config)
            .then(res => { alert('response가 가져온 ID,PW = ' + JSON.stringify(res.data)) })
    }



   
    const handleSubmitPw = () => { alert('입력한 password = ' + password) }

    return (<>
        <h2>로그인</h2>
        <h4>ID</h4>
        <input type="text" onChange={handleChange} />
        <h4>비밀번호</h4>
        <input type="text" onChange={handleChangePw} /><br /><br />
        {/* <button onClick={handleSubmitPw}>입력</button> */}
        <button onClick={handleSubmit}>입력</button>
    </>);
}