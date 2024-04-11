'use client'
import { IBoards } from "@/app/components/board/model/boards-model"
import { findBoardById } from "@/app/components/board/service/board-service"
import { getOneBoard} from "@/app/components/board/service/board-slice"
import { Typography } from "@mui/material"
import { useEffect } from "react"
import { useSelector } from "react-redux"
import { useDispatch } from "react-redux"


export default function BoardDetailPage ({params}:any)  {
    const dispatch = useDispatch()
    const oneBoard:IBoards = useSelector(getOneBoard)

    useEffect(()=>{
        dispatch(findBoardById(params.id))
    },[])

    return (<>
    <span>ID : </span><Typography textAlign="center" sx={{fontSize:"1.2rem"}}>{params.id}</Typography>
    <span>게시판이름 : </span><Typography textAlign="center" sx={{fontSize:"1.2rem"}}>{oneBoard.boardName}</Typography>
    <span>게시판종류 : </span><Typography textAlign="center" sx={{fontSize:"1.2rem"}}>{oneBoard.boardType}</Typography>
    <span>작성일자 : </span><Typography textAlign="center" sx={{fontSize:"1.2rem"}}>{oneBoard.regDate}</Typography>
    <span>수정일자 : </span><Typography textAlign="center" sx={{fontSize:"1.2rem"}}>{oneBoard.modDate}</Typography>
    </>)
}
