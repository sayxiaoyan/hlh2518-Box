# Box

=== Source Code - Editing the app default settings ===
/src/main/java/com/github/tvbox/osc/base/App.java

    private void initParams() {

        putDefault(HawkConfig.HOME_REC, 2);       // Home Rec 0=豆瓣, 1=推荐, 2=历史
        putDefault(HawkConfig.PLAY_TYPE, 1);      // Player   0=系统, 1=IJK, 2=Exo
        putDefault(HawkConfig.IJK_CODEC, "硬解码");// IJK Render 软解码, 硬解码
        putDefault(HawkConfig.HOME_SHOW_SOURCE, true);  // true=Show, false=Not show
        putDefault(HawkConfig.HOME_NUM, 2);       // History Number
        putDefault(HawkConfig.DOH_URL, 2);        // DNS
        putDefault(HawkConfig.SEARCH_VIEW, 2);    // Text or Picture

    }
	
	github命令行上传本地代码
使用Personal access token
首先，需要获取token

点击你的GitHub头像 -> 设置 -> 开发者设置 -> Personal access tokens -> Generate new token

生成token

本地上传代码
1、去github上创建自己的Repository

2、为代码库添加说明文档

echo “# AAA” >> README.md
注意：AAA是新创建的仓库名

3、建立git仓库

在上传的代码文件下，运行

git init
此时会创建一个.git文件夹。

4、将项目的所有文件添加到仓库中

git add .
5、提交到仓库

git commit -m “注释语句”
6、将本地的仓库关联到GitHub

git remote add origin https://github.com/li-zhouzhou/AAA.git
git branch -M main
git push -u origin main
更新代码

第一步：查看当前的git仓库状态，可以使用git status

git status
第二步：更新全部

git add *
第三步：接着输入git commit -m “更新说明”

git commit -m “更新说明”
第四步：先git pull,拉取当前分支最新代码（也就是获取GitHub上的最新代码信息，更新本地代码）

git pull
第五步：push到远程master分支上（修改本地代码后，再更新GitHub上的代码）

git push origin master

不出意外，打开GitHub已经同步了

注意：先pull，再push

提交代码到其他分支
一、提交代码
1、提交代码到本地库中
git commit -m '描述内容'

2、拉取该分支下的内容，与自己在本地库改写的合并
git pull origin <分支名称>

3、提交代码到github上

git push origin <分支名称>

二、合并代码
1、查看所有分支（其中带 * 号的：当前使用分支）
git branch -a

2、切换分支
git checkout <分支名称>

3、合并某分支到当前分支：
git merge <分支名称>
例如：把develop 合并到master:
git merge develop

4、提交合并的代码 ：
git pull :拉取当前仓库的代码
git push origin <分支名称> 合并提交 到主分支上
用到的git命令：

1、创建分支：
git branch <分支名称>
2、查看所有分支

git branch -a
3、切换分支

git checkout <分支名称>
4、合并某分支到当前分支：

git merge <分支名称>
5、创建+切换分支：

git checkout -b <分支名称>