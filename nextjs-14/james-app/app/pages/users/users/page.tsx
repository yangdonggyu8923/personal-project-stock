'use client'
import { IUsers } from "@/redux/features/users/user.model"
import { fetchAllUsers } from "@/redux/features/users/user.service"
import { getAllUsers } from "@/redux/features/users/user.slice"
import { NextPage } from "next"
import { useEffect } from "react"
import { useSelector } from "react-redux"
import { useDispatch } from "react-redux"

const UsersPage: NextPage = () => {
    const dispatch = useDispatch()
    const allUsers: [] = useSelector(getAllUsers)

    if(allUsers !== undefined){
        console.log('allUsers is not undefined')

        console.log('length is ' + allUsers.length)
        for(let i=0; i<allUsers.length; i++){
            console.log(JSON.stringify(allUsers[i]))
        }
    }else{
        console.log('allUsers is undefined')
    }

    useEffect(()=>{
        dispatch(fetchAllUsers(1))
    },[])

    return(<>
    <table border={1}>
        <thead>
            <tr>
                <th>아이디</th>
                <th>이름</th>
                <th>전화번호</th>
                <th>직업</th>
                <th>키</th>
                <th>체중</th>
            </tr>
        </thead>
        <tbody>
            {allUsers?.map((props:IUsers)=>(
                <tr key={props.id}>
                    <td>{props.username}</td>
                    <td>{props.name}</td>
                    <td>{props.phone}</td>
                    <td>{props.job}</td>
                    <td>{props.height}</td>
                    <td>{props.weight}</td>
                </tr>
            ))}
        </tbody>
        </table>  
    
    </>)
}

export default UsersPage