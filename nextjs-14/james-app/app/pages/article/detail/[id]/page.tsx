'use client'
import { findArticleById } from "@/app/components/article/service/article-service"
import { getOneArticles } from "@/app/components/article/service/article-slice"
import BoardColumns from "@/app/components/board/module/board-columns"
import { findAllBoards } from "@/app/components/board/service/board-service"
import { getAllBoards } from "@/app/components/board/service/board-slice"
import { Typography } from "@mui/material"
import { DataGrid } from "@mui/x-data-grid"
import { NextPage } from "next"
import { useEffect } from "react"
import { useSelector } from "react-redux"
import { useDispatch } from "react-redux"

export default function ArticleDetailPage (props:any) {
    const dispatch = useDispatch()
    const oneArticles = useSelector(getOneArticles)
    useEffect(()=>{
        dispatch(findArticleById(props.params.id))
    },[])

    return(<>
    <span>ID : </span><Typography textAlign="center" sx={{fontSize:"1.2rem"}}>{props.params.id}</Typography>
    <span>제목 : </span><Typography textAlign="center" sx={{fontSize:"1.2rem"}}>{oneArticles.title}</Typography>
    <span>내용 : </span><Typography textAlign="center" sx={{fontSize:"1.2rem"}}>{oneArticles.content}</Typography>
    <span>작성자 : </span><Typography textAlign="center" sx={{fontSize:"1.2rem"}}>{oneArticles.writerId}</Typography>
    <span>게시판 : </span><Typography textAlign="center" sx={{fontSize:"1.2rem"}}>{oneArticles.boardId}</Typography>
    <span>작성일자 : </span><Typography textAlign="center" sx={{fontSize:"1.2rem"}}>{oneArticles.regDate}</Typography>
    <span>수정일자 : </span><Typography textAlign="center" sx={{fontSize:"1.2rem"}}>{oneArticles.modDate}</Typography>
    </>)
}
