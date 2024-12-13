import request from '@/utils/request'

// 查询printerdetails列表
export function listPrinterdetails(query) {
  return request({
    url: '/wh/printerdetails/list',
    method: 'get',
    params: query
  })
}

// 查询printerdetails详细
export function getPrinterdetails(printerid) {
  return request({
    url: '/wh/printerdetails/' + printerid,
    method: 'get'
  })
}

// 新增printerdetails
export function addPrinterdetails(data) {
  return request({
    url: '/wh/printerdetails',
    method: 'post',
    data: data
  })
}

// 修改printerdetails
export function updatePrinterdetails(data) {
  return request({
    url: '/wh/printerdetails',
    method: 'put',
    data: data
  })
}

// 删除printerdetails
export function delPrinterdetails(printerid) {
  return request({
    url: '/wh/printerdetails/' + printerid,
    method: 'delete'
  })
}
