参考《Maven实战》第16章 使用SpringMVC创建REST API
    近几年来，REST已经成为替换传统SOAP Web服务的流行方案。SOAP一般关注行为和处理，而REST关注的是要处理的数据。
    REST与RPC几乎没有任何关系。RPC是面向服务的（例如HTTPInvokerProxyFactoryBean将service发布为RMI服务，客户端调用service的方法即行为），关注于行为和动作；而REST是面向资源的
 强调描述应用程序的事物和名词。
    在REST中，资源通过URL通过识别和定位。REST会有行为，他们是通过HTTP方法来定义的，具体来讲就是POST\PUT\GET\DELETE(CURD).
    借助@PathVariable，控制器能处理参数化的URL。
    注意：使用Spring的ContentNegotiatingViewerResolver作为控制视图解析器，并配置ContentNegotiationManager作为参数，设置默认值。此时，一般会配置多个视图
 解析器，ContentNegotiatingViewerResolver会根据用户请求找到合适的视图解析器（例如Accept头信息要求返回applation/json，则会优先查找返回。这里理解存在疑惑
 ，<h1>参考http://wiselyman.iteye.com/blog/2214965编写测试</h1>），并由该解析器负责具体的解析。
    ContentNegotiatingViewerResolver优势与限制
    优：当人类用户接口与非面向人类接口有大量重叠时，减少了代码的重复
    限：作为ViewerResoler的实现，只能决定资源如何渲染到客户端，并未涉及到客户端要发送什么样的表述给控制器，例如客户端发送了JSON如何处理。还有它是将选然后的结果
 发送给了客户端，而不是资源。（例如客户端要求applation/json，而返回的viewer不是标准json）
    基于以上限制，我们应该使用Spring的消息转换功能生成资源表述。
    正常情况下，当处理方法返回Java对象（除String或vie的实现以外）时，这个对象会放在模型中并在视图中渲染使用。但如果使用了消息转换功能的话，我们需要告诉Spring
 跳过正常的模型\视图流程，并使用消息转换器。最简单的方式就是添加@ResponseBody。
    一旦使用了@ResponseBody消息转换器会自动根据Accept头信息将响应转换为客户端需要的响应体。
    同理@RequestBody。
    一个好的REST API不仅能够在客户端和服务器之间传递资源，它还能狗给客户端提供额外的元数据，帮助客户端理解资源或者在请求中出现了什么情况。
    使用ResponseEntity替代@ResponseBody。ResponseEntity（它包含了@ResponseBody的语义）的优势是它可以包含响应相关的元数据（如头部信息和状态码）以及要转换成资源表述的对象。
    ResponseEntity相对@ResponseBody最大的优势在于，ResponseEntity可以在响应中设置头信息。
    编写REST客户端：使用RestTemplate可以消除样板式代码。其中exchange可以设置发送的头信息，是其他getForObject()等方法不具备的。
