import { createAsyncThunk } from "@reduxjs/toolkit";
import { fetchAllArticlesAPI } from "./article.api";

export const fetchAllArticles: any = createAsyncThunk( // 데이터를 비동기로 만들어 자바와 주고 받으려고,
    'articles/fetchAllArticles',                        // createAsyncThunk가 없으면 동기로 보내는 것
    async (page: number) => {
        console.log('fetchAllArticles page : ' + page)
        const data: any = await fetchAllArticlesAPI(1); // axios = 자바와 연결해주는 것

        const { message, result }: any = data;
        // console.log('----- API를 사용한 경우 ------')
        // console.log('message : ' + message)
        // console.log(JSON.stringify(result))
        
        return data
    }
)