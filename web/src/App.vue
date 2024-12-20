<script setup>
import { NConfigProvider } from "naive-ui";
import { zhCN, dateZhCN, darkTheme } from "naive-ui";

const globalTheme = ref(darkTheme)

//:theme="globalTheme"
</script>

<template>
  <header></header>

  <main>
    <n-config-provider :locale="zhCN" :date-locale="dateZhCN">
      <n-message-provider>
        <n-dialog-provider>
          <n-modal-provider>
            <router-view v-slot="{ Component, route }">
              <component :is="Component" />
            </router-view>
          </n-modal-provider>
        </n-dialog-provider>
      </n-message-provider>
    </n-config-provider>
  </main>
</template>

<style scoped></style>