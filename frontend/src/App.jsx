import { useState, useEffect } from 'react'
import axios from 'axios';
import { Space, Typography, Modal, Form, Table, Button, } from "antd";
import Title from 'antd/es/skeleton/Title';

const data = [
  {
    id: 1,
    name: "Product 1",
    price: 10.99
  },
  {
    id: 2,
    name: "Product 2",
    price: 15.99
  }
];

function App() {
  // useEffect(async () => {
  //   try{
  //     await axios.get("http://localhost:8080/products").then((response) => {
  //       console.log(response.data);
  //     });
  //   }catch(err){
  //     console.log(err);
  //   }
  // });

  const [arrayOfCount, setArrayOfCount] = useState({});

  const productColumns = [
    {
      title: "S.No",
      key: "sno",
      render: (_, record, index) => index + 1
    },
    {
      title: "Product",
      dataIndex: "name",
      key: "name",
    },
    {
      title: "Price",
      dataIndex: "price",
      key: "price"
    },
    {
      title: "Decrement Item",
      dataIndex: "decItem",
      key: "decItem",
      render: (_, record) => <Button type="primary" danger onClick={() => decrementItem(record.id)}> - </Button>
    },
    {
      title: "Add Item",
      dataIndex: "addItem",
      key: "addItem",
      render: (_, record) => <Button type="primary" onClick={() => incremenetItem(record.id)}> + </Button>
    },
    {
      title: "Cart Count",
      dataIndex: "count",
      key: "count",
      render: (_, record) => <span>{arrayOfCount[record.id] || 0}</span>
    }];

  const incremenetItem = (id) => {
    setArrayOfCount((prev) => ({
      ...prev,
      [id]: (prev[id] || 0) + 1
    }))
  };

  const decrementItem = (id) => {
    setArrayOfCount((prev) => ({
      ...prev,
      [id]: Math.max(0, (prev[id] || 0) - 1)
    }))
  };

  const totalCount = Object.values(arrayOfCount).reduce((sum, count) => sum + count , 0);

  const totalPrice = data.reduce((sum, product) => sum + product.price * (arrayOfCount[product.id] || 0));



  return (
    <div style={{ maxWidth: "1100", margin: "32px", padding: "20px" }}>
      <Space orientation='vertical' size='large' style={{ width: '100%' }}>
        <Typography.Title>Inventory Management</Typography.Title>
        <Table rowKey="id" columns={productColumns} dataSource={data} pagination={{ pageSize: 10 }} locale={{ emptyText: "No products Found", }}></Table>
        <Space size="small" style={{gap: "450px"}}><Typography.Title level={4}>Total Items : {totalCount}</Typography.Title>
          <Typography.Title level={4}>Total Price : {totalPrice}</Typography.Title></Space>
      </Space>
    </div>
  );
}

export default App
