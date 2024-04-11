'use client'
import AxiosConfig from "@/app/components/common/configs/axios-config"
import { PG } from "@/app/components/common/enums/PG"
import { IUsers } from "@/app/components/user/model/users-model"
import { findUserById, modifyUser } from "@/app/components/user/service/user-service"
import { getModifyUser, getOneUser, handleChangePassword } from "@/app/components/user/service/user-slice"
import { Button, Input, Typography } from "@mui/material"
import { useRouter } from "next/navigation"
import { useEffect, useState } from "react"
import { useSelector } from "react-redux"
import { useDispatch } from "react-redux"

export default function UserDetailPage({params}:any){
    const router = useRouter();
    const dispatch = useDispatch()
    const oneUser:IUsers = useSelector(getOneUser)

    const updatePassword = (e:any) => dispatch(handleChangePassword(e.target.value))
    const handleModifyUser = () => {
        dispatch(modifyUser(oneUser))
        router.push(`${PG.USER}/list`)
    }

    
    useEffect(()=>{
        dispatch(findUserById(params.id))
    },[])
    return(<>
    <span>ID : </span><Typography textAlign="center" sx={{fontSize:"1.2rem"}}>{params.id}</Typography>
    <span>아이디 : </span><Typography textAlign="center" sx={{fontSize:"1.2rem"}}>{oneUser.username}</Typography>
    <span>비밀번호 : </span><Input type="password" name="password" placeholder={"********"} onChange={updatePassword}></Input><br />
    <span>이름 : </span><Typography textAlign="center" sx={{fontSize:"1.2rem"}}>{oneUser.name}</Typography>
    <span>전화번호 : </span><Input type="text" name="phone" placeholder={oneUser.phone} onChange={updatePassword}></Input><br />
    <span>직업 : </span><Input type="text" name="job" placeholder={oneUser.job} onChange={updatePassword}></Input><br />
    <span>작성일자 : </span><Typography textAlign="center" sx={{fontSize:"1.2rem"}}>{oneUser.regDate}</Typography>
    <span>수정일자 : </span><Typography textAlign="center" sx={{fontSize:"1.2rem"}}>{oneUser.modDate}</Typography>
    <Button onClick={handleModifyUser}>수정</Button>
    </>)
}
