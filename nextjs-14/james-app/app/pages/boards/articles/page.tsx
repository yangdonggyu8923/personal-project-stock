'use client'
import { useState, useEffect } from "react"
import { useSelector, useDispatch } from 'react-redux';
import { NextPage } from "next";
import { fetchAllArticles } from "@/redux/features/articles/article.service";
import { getAllArticles } from "@/redux/features/articles/article.slice";
// import React from "react";

interface IArticle {
    id: number,
    title: string,
    content: string,
    writer: string,
    registerDate: string
}

const ArticlesPage: NextPage = () => {
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
        <table border={1}>
            <thead>
                <tr>
                    <th>title</th>
                    <th>content</th>
                    <th>writer</th>
                    <th>registerDate</th>
                </tr>
            </thead>
            <tbody>
                {allArticles?.map((props: IArticle) => (
                    <tr key={props.id}>
                        <td>{props.title}</td>
                        <td>{props.content}</td>
                        <td>{props.writer}</td>
                        <td>{props.registerDate}</td>
                    </tr>
                ))}
            </tbody>
        </table>
    </>)
}

export default ArticlesPage