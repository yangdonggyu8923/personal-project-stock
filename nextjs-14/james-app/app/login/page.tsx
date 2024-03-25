'use client';
import Image from "next/image";
import { useState } from "react";
import axios from 'axios'
import Link from "next/link";
const SERVER = 'http://localhost:8080'
export default function login() {

  const [username, setUsername] = useState('')
  const [password, SetPassword] = useState('')

  const handleUsername = (e:any) => {setUsername(e.target.value)}
  const handlePassword = (e:any) => {SetPassword(e.target.value)}

  
  const handleSubmit = () => {alert("request가 가져가는 입력 ID" + username)
  const url = `${SERVER}/api/login`
  const data = {username , password} // <- (원본 un : un, pw : pw ) Key & value가 같으면 생략가능 -> username : username ~
  const config = {
    headers:{
      "Cache-Control": "no-cache",
      "Content-Type": "application/json",
       Authorization: `Bearer blah ~` ,
      "Access-Control-Allow-Origin": "*",
    }   
  }
  axios.post(url,data,config) // = requestbody
  .then(res=>{                            // res.data.messenger = 자바의 "messenger", 
    const messenger = res.data.messenger   // JSON.stringify = toString() , res.data = responsebody
    alert((messenger))
  })
}


  
  return(<>
  <h1>로그인</h1>
  <h3>ID</h3>
  <input type = "text" onChange={handleUsername}/>
  <h3>Password</h3>
  <input type = "text" onChange={handlePassword}/> <br /> <br />
  <button onClick={handleSubmit}>전송</button>
  </>);
}
