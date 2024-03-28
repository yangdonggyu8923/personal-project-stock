'use client';
import axios from "axios";
import { useRouter } from "next/navigation";
import { useEffect, useState } from 'react';
import { DataGrid } from '@mui/x-data-grid';
import { Box, Button, Input } from '@mui/material';
import { API } from "@/app/atoms/enums/API";
import AxiosConfig from "@/app/organisms/configs/axios-config";
import ArticlesRows from "@/app/organisms/rows/articles-rows";
import ArticlesColumns from "@/app/organisms/columns/articles-columns";


interface IArticle {
    id: number,
    title: string,
    content: string,
    writer: string,
    registerDate: string
}


export default function Articles() {
    const router = useRouter();
    const [articles, setArticles] = useState([]);

    const url = `${API.SERVER}/api/articles`
    const config = AxiosConfig();
    useEffect(() => {
        {
            axios.get(url, config).then(res => {
                const message = res.data.message
                console.log((message))
                if (message === 'SUCCESS') {
                    console.log("게시글이 있습니다.")
                    const arr = res.data.result
                    for (let element of arr) {
                        console.log(element)
                    }
                    setArticles(res.data.result)
                }
                else if (message === 'FAIL') {
                    console.log('게시글이 없습니다.');
                }
                else {
                    console.log("지정되지 않은 값")
                }

            })
        }
    }, [])

    return (
        <>
        <h1>게시글 목록</h1>
            
            {/* <Box sx={{ height: 400, width: '100%' }}>
      <DataGrid
        rows={ArticlesRows()}
        columns={ArticlesColumns}
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
    </Box> */}
    </>
    );
}
