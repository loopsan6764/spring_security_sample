package com.example.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// Spring Securityの設定を有効にします
@EnableWebSecurity
// WebSecurityConfigurerAdapterを必ず継承しましょう
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 認証・認可に関する設定を追加します
    	// 認可の設定
        http.authorizeRequests()
            .antMatchers("/loginForm").permitAll() // /loginFormは、全ユーザからのアクセスを許可
            .anyRequest().authenticated(); // 許可した項目以外は、認証を求める
    }
    
    http.formLogin()
    	.loginProcessingUrl("/login") // ログイン処理のパス
    	.loginPage("/loginForm") // ログインページの指定
    	.usernameParameter("email") // ログインページのメールアドレス
    	.passwordParameter("password") // ログインページのパスワード
    	.defaultSuccessUrl("/home", true) // ログイン成功後のパス
    	.failureUrl("/loginForm?error"); // ログイン失敗時のパス
}

//ログアウト処理
http.logout()
    .logoutUrl("/logout") //ログアウト処理のパス
    .logoutSuccessUrl("/loginForm"); //ログアウト成功後のパス
}