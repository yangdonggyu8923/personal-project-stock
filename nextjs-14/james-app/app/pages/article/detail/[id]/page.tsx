'use client'
import { IArticles } from "@/app/components/article/model/articles-model"
import { findArticleById } from "@/app/components/article/service/article-service"
import { getOneArticle } from "@/app/components/article/service/article-slice"
import { Typography } from "@mui/material"
import { DataGrid } from "@mui/x-data-grid"
import { NextPage } from "next"
import { useEffect } from "react"
import { useSelector } from "react-redux"
import { useDispatch } from "react-redux"

export default function ArticleDetailPage({params}:any){
    const dispatch = useDispatch()
    const oneArticle:IArticles = useSelector(getOneArticle)
    useEffect(()=>{
        dispatch(findArticleById(params.id))
    },[])

    return(<>
    <span>ID : </span><Typography textAlign="center" sx={{fontSize:"1.2rem"}}>{params.id}</Typography>
    <span>제목 : </span><Typography textAlign="center" sx={{fontSize:"1.2rem"}}>{oneArticle.title}</Typography>
    <span>내용 : </span><Typography textAlign="center" sx={{fontSize:"1.2rem"}}>{oneArticle.content}</Typography>
    <span>작성자 : </span><Typography textAlign="center" sx={{fontSize:"1.2rem"}}>{oneArticle.writerId}</Typography>
    <span>게시판 : </span><Typography textAlign="center" sx={{fontSize:"1.2rem"}}>{oneArticle.boardId}</Typography>
    <span>작성일자 : </span><Typography textAlign="center" sx={{fontSize:"1.2rem"}}>{oneArticle.regDate}</Typography>
    <span>수정일자 : </span><Typography textAlign="center" sx={{fontSize:"1.2rem"}}>{oneArticle.modDate}</Typography>
    </>)
}