'use client'
import { useState, useEffect } from "react"
import { useSelector, useDispatch } from 'react-redux';
import { NextPage } from "next";
import { fetchAllArticles } from "@/redux/features/articles/article.service";
import { getAllArticles } from "@/redux/features/articles/article.slice";
import Columns from "@/app/component/articles/columns";
import { Box } from "@mui/material";
import { DataGrid } from "@mui/x-data-grid";

interface IArticle {
    id: number,
    title: string,
    content: string,
    writer: string,
    registerDate: string
}

const ArticlesPage: NextPage = ({data}:any) => {
    const dispatch = useDispatch()  // 레퍼런스 있음 = 의존관계
    // const [articles, setArticles] = useState([]) -> 상태가 리액트에 없고 리덕스에 있다 = 무상태 프로그래밍
    const allArticles: [] = useSelector(getAllArticles)  // 레퍼런스 있음 = 의존관계

    if(allArticles !== undefined){
        console.log('allArticles is not undefined')

        console.log('length is ' + allArticles.length)
        for(let i=0; i<allArticles.length; i++){
            console.log(JSON.stringify(allArticles[i]))
        }
    }else{
        console.log('allArticles is undefined')
    }


    useEffect(() => {   // 레퍼런스 없음 = 의존관계 아님, 
        dispatch(fetchAllArticles(1))    // 실행 순서: useEffect -> dispatch -> fetchAllArticles
    }, [])  // [dispatch]의 상태가 바뀌면 useEffect를 다시 실행한다 (나중에 다시 설명)
    
    return (<>
    <h2>게시글 목록</h2>
        <Box sx={{ height: 400, width: '100%' }}>
      <DataGrid
        rows={data}
        columns={Columns()}
        initialState={{
          pagination: {
            paginationModel: {
              pageSize: 5,
            },
          },
        }}
        pageSizeOptions={[5]}
        checkboxSelection
        disableRowSelectionOnClick
      />
    </Box>
    </>)
}

export default ArticlesPage