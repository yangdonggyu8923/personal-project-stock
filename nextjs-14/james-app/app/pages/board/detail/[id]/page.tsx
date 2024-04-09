'use client'
import { ArticleColumn } from "@/app/components/article/model/articles-column"
import { getAllArticles } from "@/app/components/article/service/article-slice"
import BoardColumns from "@/app/components/board/module/board-columns"
import { findAllBoards } from "@/app/components/board/service/board-service"
import { getAllBoards } from "@/app/components/board/service/board-slice"
import { Typography } from "@mui/material"
import { DataGrid } from "@mui/x-data-grid"
import { NextPage } from "next"
import { useEffect } from "react"
import { useSelector } from "react-redux"
import { useDispatch } from "react-redux"


export default function BoardDetailPage (props:any)  {
    const dispatch = useDispatch()
    

    useEffect(()=>{
        // dispatch(findBoardById(props.params.id))
    },[])

    return(<>
    <h2>{props.params.id}번 게시판 상세</h2>
    <span>ID : </span><Typography textAlign="center" sx={{fontSize:"1.5rem"}}>{props.params.id}</Typography>
    <span>게시판이름 : </span><Typography textAlign="center" sx={{fontSize:"1.5rem"}}>{props.boardType}</Typography>
    <span>게시판종류 : </span><Typography textAlign="center" sx={{fontSize:"1.5rem"}}>{props.boardType}</Typography>
    <span>작성일자 : </span><Typography textAlign="center" sx={{fontSize:"1.5rem"}}>{props.boardType}</Typography>
    <span>수정일자 : </span><Typography textAlign="center" sx={{fontSize:"1.5rem"}}>{props.boardType}</Typography>
    </>)
}
