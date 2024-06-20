<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%
// json에서 ajax로 바로 로드가 안됨(CORS), JSON -> JSP ->외부로 송출
response.addHeader("Access-Control-Allow-Origin","*"); 
// * : 모든 프로토콜을 받음, 특정 도메인 : http://172.30.1.85:8080 특정 IP 가능(port 포함)
response.addHeader("Access-Control-Allow-Credentials","true");
%>
{
    "datas" : [
        {
    "1" : [
        {
            "seoul":114,
            "gyeonggi":32,
            "incheon":12,
            "city":41
        }
    ],
    "2" : [
        {
            "seoul":93,
            "gyeonggi":27,
            "incheon":12,
            "city":16
        }
    ],
    "3" : [
        {
            "seoul":67,
            "gyeonggi":14,
            "incheon":12,
            "city":7
        }
    ],
    "4" : [
        {
            "seoul":45,
            "gyeonggi":12,
            "incheon":12,
            "city":8
        }
    ],
    "5" : [
        {
            "seoul":28,
            "gyeonggi":8,
            "incheon":12,
            "city":11
        }
    ],        
    "6" : [
        {
            "seoul":16,
            "gyeonggi":6,
            "incheon":12,
            "city":19
        }
    ],
    "7" : [
        {
            "seoul":32,
            "gyeonggi":11,
            "incheon":12,
            "city":9
        }
    ],        
    "8" : [
        {
            "seoul":49,
            "gyeonggi":9,
            "incheon":12,
            "city":16
        }
    ],
    "9" : [
        {
            "seoul":34,
            "gyeonggi":6,
            "incheon":12,
            "city":3
        }
    ],        
    "10" : [
        {
            "seoul":21,
            "gyeonggi":4,
            "incheon":12,
            "city":7
        }
    ],        
    "11" : [
        {
            "seoul":19,
            "gyeonggi":6,
            "incheon":12,
            "city":17
        }
    ],
    "12" : [
        {
            "seoul":7,
            "gyeonggi":2,
            "incheon":12,
            "city":16
        }
    ]
        }
        ]
}