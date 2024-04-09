'use client'
import { ArticleColumn } from "@/app/components/article/model/articles-column"
import { getAllArticles } from "@/app/components/article/service/article-slice"
import BoardColumns from "@/app/components/board/module/board-columns"
import { findAllBoards } from "@/app/components/board/service/board-service"
import { getAllBoards } from "@/app/components/board/service/board-slice"
import { DataGrid } from "@mui/x-data-grid"
import { NextPage } from "next"
import { useEffect } from "react"
import { useSelector } from "react-redux"
import { useDispatch } from "react-redux"

interface CellType{
    row : ArticleColumn
}
export default function BoardDetailPage (props:any)  {
    
    return(<>
    <h2>{props.params.id}번 게시판 상세</h2>
    </>)
}